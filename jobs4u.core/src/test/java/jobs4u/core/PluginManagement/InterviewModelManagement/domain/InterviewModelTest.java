package jobs4u.core.PluginManagement.InterviewModelManagement.domain;

import jobs4u.core.PluginManagement.Description;
import jobs4u.core.PluginManagement.FQClassName;
import jobs4u.core.customerusermanagement.domain.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewModelTest {
    @Test
    void testConstructorAndGetters() {
        Name name = new Name("Formula One");
        Description description = new Description("Formula One Quiz");
        FQClassName className = FQClassName.valueOf("Other.InterviewModel_EX1");

        InterviewModel model = new InterviewModel(name, description, className);

        assertEquals(name, model.getName());
        assertEquals(description, model.getDescription());
        assertEquals(className, model.getClassName());
    }

    @Test
    void testEqualsAndHashCode() {
        FQClassName className1 = FQClassName.valueOf("Other.InterviewModel_EX1");
        FQClassName className2 = FQClassName.valueOf("Other.InterviewModel_EX1");

        InterviewModel model1 = new InterviewModel(new Name("Formula One"), new Description("Formula One Quiz"), className1);
        InterviewModel model2 = new InterviewModel(new Name("Formula One"), new Description("Formula One Quiz"), className1);
        InterviewModel model3 = new InterviewModel(new Name("Front End Junior Programmer"), new Description("Work hard and get nothing."), className2);

        assertEquals(model1, model2);
        assertNotEquals(model1, model3);
        assertEquals(model1.hashCode(), model2.hashCode());
        assertNotEquals(model1.hashCode(), model3.hashCode());
    }

    @Test
    void testToString() {
        FQClassName className = FQClassName.valueOf("Other.InterviewModel_EX1");
        InterviewModel model = new InterviewModel(new Name("Formula One"), new Description("Formula One Quiz"), className);
        String expectedToString = "InterviewModel{name='Formula One', description='Formula One Quiz', className='" + className + "'}";

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
