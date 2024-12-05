package jobs4u.core.jobapplicationmanagement.application.Services;

import eapli.framework.general.domain.model.Designation;
import jakarta.transaction.Transactional;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobapplicationmanagement.repositories.JobApplicationRepository;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.repositories.JobOpeningRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Job application evaluator service.
 */
@SuppressWarnings("CallToPrintStackTrace")
public class JobApplicationEvaluatorService {
    private final Designation jobReference;
    //private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * Instantiates a new Job application evaluator service.
     *
     * @param jobReference the job reference
     */
    public JobApplicationEvaluatorService(Designation jobReference) {
        this.jobReference = jobReference;
    }

    private FileJobApp findRequirementsFile(List<FileJobApp> files) {
        return files.stream()
                .filter(file -> file.getValue().toLowerCase().contains("requirement"))
                .findFirst()
                .orElse(null);
    }

    private Object loadPluginMethod(String methodToInvoke, RequirementSpecification requirementSpecification, Object... parameters) {
        Object result = null;
        try {
            FQClassName fqClassName = requirementSpecification.getClassName();

            Class<?> clazz = Class.forName(fqClassName.toString());

            Object instance = clazz.getDeclaredConstructor().newInstance();

            Class<?>[] parameterTypes = new Class[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                parameterTypes[i] = parameters[i].getClass();
            }

            Method method = clazz.getMethod(methodToInvoke, parameterTypes);

            result = method.invoke(instance, parameters);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Verify requirements list.
     *
     * @param jobApplicationId the job application id
     * @return the list
     */
    @Transactional
    public List<String> verifyRequirements(Long jobApplicationId) {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);

        List<String> executionMessages = new ArrayList<>();
        JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
        JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

        JobOpening jobOpening = jobOpeningRepository.findByReference(jobReference).orElse(null);
        if (jobOpening == null) {
            executionMessages.add("Job opening not found");
            return executionMessages;
        }

        JobApplication jobApplication = jobApplicationRepository.findJobApplicationById(jobApplicationId).orElse(null);
        if (jobApplication == null) {
            executionMessages.add("Job application not found");
            return executionMessages;
        }

        RequirementSpecification requirementSpecification = jobOpening.toDTO().getRequirements();
        if (requirementSpecification == null) {
            executionMessages.add("No requirements found for job opening " + jobReference);
            return executionMessages;
        }

        String methodToInvoke = "generateTemplateResponses";
        String templateResponsesFilePath = (String) loadPluginMethod(methodToInvoke, requirementSpecification);

        List<FileJobApp> files = jobApplication.toDTO().getFile();
        if (files.isEmpty()) {
            executionMessages.add("No candidate files found for job application " + jobApplication.toDTO().getID() + " for job opening " + jobReference);
            return executionMessages;
        }
        FileJobApp requirementsFile = findRequirementsFile(files);
        if (requirementsFile == null) {
            executionMessages.add("No requirements file found for job application " + jobApplication.toDTO().getID() + " for job opening " + jobReference);
            return executionMessages;
        }
        String candidateAnswersFilePath = requirementsFile.getValue();
        String methodToInvoke2 = "evaluateFile";
        int verificationResult = (int) loadPluginMethod(methodToInvoke2, requirementSpecification, templateResponsesFilePath, candidateAnswersFilePath);

        jobApplication.updateStateBasedOnVerificationResult(verificationResult);
        executionMessages.add("Verification result for job application " + jobApplication.toDTO().getID() + " for job opening " + jobReference + ": " + verificationResult + ". State: " + jobApplication.toDTO().getState());
        jobApplicationRepository.save(jobApplication);

        try {
            Files.deleteIfExists(Path.of(templateResponsesFilePath));
        } catch (IOException e) {
            executionMessages.add("Error deleting file " + templateResponsesFilePath + ": You may need to delete it manually");
        }
        return executionMessages;
    }
}
