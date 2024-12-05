package jobs4u.core.PluginManagement;

import jobs4u.core.jobapplicationmanagement.domain.JobApplication;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

@Service
public class FileService {

    public void createDirectoryIfNotExistsJP(JobOpening jobOpening) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "CandidateAnswers", jobOpening.identity().toString());
        if (!Files.exists(jobOpeningDirectory)) {
            Files.createDirectory(jobOpeningDirectory);
        }
    }

    public void createDirectoryIfNotExistsJPRequirements(JobOpening jobOpening) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "RequirementsAnswers", jobOpening.identity().toString());
        if (!Files.exists(jobOpeningDirectory)) {
            Files.createDirectory(jobOpeningDirectory);
        }
    }

    public void createDirectoryIfNotExistsJA(JobOpening jobOpening, JobApplication jobApplication) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "CandidateAnswers", jobOpening.identity().toString());
        if (!Files.exists(jobOpeningDirectory)) {
            Files.createDirectory(jobOpeningDirectory);
        }

        Path jobApplicationDirectory = jobOpeningDirectory.resolve(jobApplication.identity().toString());
        if (!Files.exists(jobApplicationDirectory)) {
            Files.createDirectory(jobApplicationDirectory);
        }
    }

    public void createDirectoryIfNotExistsJARequirements(JobOpening jobOpening, JobApplication jobApplication) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "RequirementsAnswers", jobOpening.identity().toString());
        if (!Files.exists(jobOpeningDirectory)) {
            Files.createDirectory(jobOpeningDirectory);
        }

        Path jobApplicationDirectory = jobOpeningDirectory.resolve(jobApplication.identity().toString());
        if (!Files.exists(jobApplicationDirectory)) {
            Files.createDirectory(jobApplicationDirectory);
        }
    }

    public String moveFileJA(String filePath, JobOpening jobOpening, JobApplication jobApplication) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "CandidateAnswers", jobOpening.identity().toString());
        Path jobApplicationDirectory = jobOpeningDirectory.resolve(jobApplication.identity().toString());

        Path sourcePath = Paths.get(filePath);
        Path targetPath = jobApplicationDirectory.resolve(sourcePath.getFileName());
        Files.move(sourcePath, targetPath);
        return targetPath.toString();
    }

    public String moveFileJARequirements(String filePath, JobOpening jobOpening, JobApplication jobApplication) throws IOException {
        Path jobOpeningDirectory = Paths.get("docs", "RequirementsAnswers", jobOpening.identity().toString());
        Path jobApplicationDirectory = jobOpeningDirectory.resolve(jobApplication.identity().toString());

        Path sourcePath = Paths.get(filePath);
        Path targetPath = jobApplicationDirectory.resolve(sourcePath.getFileName());
        Files.move(sourcePath, targetPath);
        return targetPath.toString();
    }
}