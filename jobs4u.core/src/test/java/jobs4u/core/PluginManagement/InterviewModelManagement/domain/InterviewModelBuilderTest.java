package jobs4u.core.PluginManagement.InterviewModelManagement.domain;

import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.PluginManagement.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewModelBuilderTest {
    @Test
    void testBuild() {
        Name name = new Name("Formula One");
        Description description = new Description("Formula One Quiz");
        FQClassName className = FQClassName.valueOf("Other.InterviewModel_EX1");

        InterviewModelBuilder builder = new InterviewModelBuilder()
                .withName(name)
                .withDescription(description)
                .withClassName(className);

        InterviewModel model = builder.build();

        assertNotNull(model);
        assertEquals(name, model.getName());
        assertEquals(description, model.getDescription());
        assertEquals(className, model.getClassName());
    }

    @Test
    void testBuildWithDefaults() {
        InterviewModelBuilder builder = new InterviewModelBuilder();
        InterviewModel model = builder.build();

        assertNotNull(model);
        assertNull(model.getName());
        assertNull(model.getDescription());
        assertNull(model.getClassName());
    }
}