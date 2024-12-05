
package jobs4u.core.PluginManagement.RequirementsSpecificationManagement.domain;

import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import jobs4u.core.customerusermanagement.domain.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequirementSpecificationTest {

    @Test
    void testConstructorAndGetters() {
        Name name = new Name("Front End Junior ");
        Description description = new Description("Work hard and get nothing.");
        FQClassName className = FQClassName.valueOf("Other.JobRequirementsSpecification_EX1");

        RequirementSpecification model = new RequirementSpecification(name, description, className);

        assertEquals(name, model.getName());
        assertEquals(description, model.getDescription());
        assertEquals(className, model.getClassName());
    }

    @Test
    void testEqualsAndHashCode() {
        FQClassName className1 = FQClassName.valueOf("Other.JobRequirementsSpecification_EX1");
        FQClassName className2 = FQClassName.valueOf("Other.JobRequirementsSpecification_EX1");

        RequirementSpecification model1 = new RequirementSpecification(new Name("Front End Junior Programmer"), new Description("Work hard and get nothing."), className1);
        RequirementSpecification model2 = new RequirementSpecification(new Name("Front End Junior Programmer"), new Description("Work hard and get nothing."), className1);
        RequirementSpecification model3 = new RequirementSpecification(new Name("Formula One"), new Description("Formula One Quiz"), className2);

        assertEquals(model1, model2);
        assertNotEquals(model1, model3);
        assertEquals(model1.hashCode(), model2.hashCode());
        assertNotEquals(model1.hashCode(), model3.hashCode());
    }

    @Test
    void testToString() {
        FQClassName className = FQClassName.valueOf("Other.JobRequirementsSpecification_EX1");
        InterviewModel model = new InterviewModel(new Name("Front End Junior Programmer"), new Description("Work hard and get nothing."), className);
        String expectedToString = "InterviewModel{name='Front End Junior Programmer', description='Work hard and get nothing.', className='" + className + "'}";

        assertEquals(expectedToString, model.toString());
    }

    @Test
    void testDefaultConstructor() {
        InterviewModel model = new InterviewModel();
        assertNull(model.getName());
        assertNull(model.getDescription());
        assertNull(model.getClassName());
    }

}
