package jobs4u.core.interviewmanagement.domain;

import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InterviewBuilderTest {

    @Test
    void withId() {
        InterviewBuilder builder = new InterviewBuilder();
        builder.withId(1L);
        Interview interview = builder.build();

        assertEquals(1L, interview.getId());
    }

    @Test
    void withDate() {
        Date date = new Date();
        InterviewBuilder builder = new InterviewBuilder();
        builder.withDate(date);
        Interview interview = builder.build();

        assertEquals(date, interview.getDate());
    }

    @Test
    void withGrade() {
        String grade = "A";
        InterviewBuilder builder = new InterviewBuilder();
        builder.withGrade(grade);
        Interview interview = builder.build();

        assertEquals(grade, interview.getGrade());
    }

    @Test
    void withInterviewModel() {
        InterviewModel model = new InterviewModel();
        InterviewBuilder builder = new InterviewBuilder();
        builder.withInterviewModel(model);
        Interview interview = builder.build();

        assertEquals(model, interview.getInterviewModel());
    }

    @Test
    void build() {
        Long id = 1L;
        Date date = new Date();
        String grade = "A";
        InterviewModel model = new InterviewModel();

        InterviewBuilder builder = new InterviewBuilder();
        Interview interview = builder.withId(id)
                .withDate(date)
                .withGrade(grade)
                .withInterviewModel(model)
                .build();

        assertEquals(id, interview.getId());
        assertEquals(date, interview.getDate());
        assertEquals(grade, interview.getGrade());
        assertEquals(model, interview.getInterviewModel());
    }
}