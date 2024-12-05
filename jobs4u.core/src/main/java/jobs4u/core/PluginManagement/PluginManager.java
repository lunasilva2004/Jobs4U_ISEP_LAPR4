package jobs4u.core.PluginManagement;

import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain.RequirementSpecification;
import jobs4u.core.customerusermanagement.domain.Name;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PluginManager {
    private Map<String, InterviewModel> interviewModelPlugins;
    private Map<String, RequirementSpecification> requirementSpecificationPlugins;

    public PluginManager() {
        interviewModelPlugins = new HashMap<>();
        requirementSpecificationPlugins = new HashMap<>();
    }

    public void loadInterviewModelPlugin(String fullyQualifiedClassName, String pathToClass, String name) throws Exception {
        System.out.println("Attempting to load InterviewModel plugin: " + fullyQualifiedClassName);

        if (!fullyQualifiedClassName.equals("Other.InterviewModel_EX1")) {
            throw new IllegalArgumentException("Invalid class name. Only Other.InterviewModel_EX1 is allowed.");
        }

        URL[] urls = { new URL("file:" + pathToClass) };
        URLClassLoader loader = new URLClassLoader(urls);

        Class<?> clazz = Class.forName(fullyQualifiedClassName, true, loader);
        System.out.println("Loaded class: " + clazz.getName());
        System.out.println("Interfaces implemented by the class: ");
        for (Class<?> iface : clazz.getInterfaces()) {
            System.out.println(iface.getName());
        }

        if (Interface.InterviewModelInterface.class.isAssignableFrom(clazz)) {
//            Interface.InterviewModelInterface plugin = (Interface.InterviewModelInterface) clazz.getDeclaredConstructor().newInstance();
            InterviewModel interviewModel = new InterviewModel(new Name(name), new Description("Description"), new FQClassName(fullyQualifiedClassName));
            interviewModelPlugins.put(interviewModel.getName().getValue(), interviewModel);
            System.out.println("Loaded and stored InterviewModel plugin: " + fullyQualifiedClassName);
        } else {
            System.out.println("Class loaded is not an InterviewModel: " + fullyQualifiedClassName);
        }
    }

    public void loadRequirementSpecificationPlugin(String fullyQualifiedClassName, String pathToClass) throws Exception {
        // Check if the class name matches your two specific classes
        if (!fullyQualifiedClassName.equals("Other.JobRequirementsSpecification_EX1")) {
            throw new IllegalArgumentException("Invalid class name. Only Other.JobRequirementsSpecification_EX1 is allowed.");
        }

        URL[] urls = { new URL("file:" + pathToClass) };
        URLClassLoader loader = new URLClassLoader(urls);

        Class<?> clazz = Class.forName(fullyQualifiedClassName, true, loader);
        if (RequirementSpecification.class.isAssignableFrom(clazz)) {
            RequirementSpecification plugin = (RequirementSpecification) clazz.getDeclaredConstructor().newInstance();
            requirementSpecificationPlugins.put(plugin.getName().toString(), plugin);
        }
    }

    public InterviewModel getInterviewModelPlugin(Name name) {
        InterviewModel plugin = interviewModelPlugins.get(name.getValue());
        if (plugin == null) {
            System.out.println("No InterviewModel plugin found with name: " + name.getValue());
        } else {
            System.out.println("Retrieved InterviewModel plugin with name: " + name.getValue());
        }
        return plugin;
    }

    public RequirementSpecification getRequirementSpecificationPlugin(String name) {
        return requirementSpecificationPlugins.get(name);
    }
}