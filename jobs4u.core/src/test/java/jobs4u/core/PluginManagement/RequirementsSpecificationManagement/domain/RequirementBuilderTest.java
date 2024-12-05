package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain;

import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequirementBuilderTest {
    @Test
    void testBuild() {
        Name name = new Name("Front End Junior ");
        Description description = new Description("Work hard and get nothing.");
        FQClassName className = FQClassName.valueOf("Other.JobRequirementsSpecification_EX1");

        RequirementBuilder builder = new RequirementBuilder()
                .withName(String.valueOf(name))
                .withDescription(String.valueOf(description))
                .withClassName(className);

        RequirementSpecification model = builder.build();

        assertNotNull(model);
        assertEquals(name, model.getName());
        assertEquals(description, model.getDescription());
        assertEquals(className, model.getClassName());
    }

    @Test
    void testBuildWithDefaults() {
        RequirementBuilder builder = new RequirementBuilder();
        RequirementSpecification model = builder.build();

        assertNotNull(model);
        assertNull(model.getName());
        assertNull(model.getDescription());
        assertNull(model.getClassName());
    }
}
