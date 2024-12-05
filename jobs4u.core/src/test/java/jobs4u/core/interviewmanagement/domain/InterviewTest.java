package jobs4u.core.interviewmanagement.domain;

import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTest {

    @Test
    void testEquals() {
        Interview interview1 = new InterviewBuilder().withId(1L).withDate(new Date()).withGrade("A").withInterviewModel(new InterviewModel()).build();
        Interview interview2 = new InterviewBuilder().withId(1L).withDate(new Date()).withGrade("A").withInterviewModel(new InterviewModel()).build();
        Interview interview3 = new InterviewBuilder().withId(2L).withDate(new Date()).withGrade("B").withInterviewModel(new InterviewModel()).build();

        assertEquals(interview1, interview2);
        assertNotEquals(interview1, interview3);
    }

    @Test
    void testSameAs() {
        Interview interview1 = new InterviewBuilder().withId(1L).withDate(new Date()).withGrade("A").withInterviewModel(new InterviewModel()).build();
        Interview interview2 = new InterviewBuilder().withId(1L).withDate(new Date()).withGrade("A").withInterviewModel(new InterviewModel()).build();
        Interview interview3 = new InterviewBuilder().withId(2L).withDate(new Date()).withGrade("B").withInterviewModel(new InterviewModel()).build();

        assertTrue(interview1.sameAs(interview2));
        assertFalse(interview1.sameAs(interview3));
    }

    @Test
    void testUpdateInterviewModel() {
        Interview interview = new InterviewBuilder().withId(1L).withDate(new Date()).withGrade("A").withInterviewModel(new InterviewModel()).build();
        InterviewModel newModel = new InterviewModel();
        interview.updateInterviewModel(newModel);

        assertEquals(newModel, interview.getInterviewModel());
    }
}