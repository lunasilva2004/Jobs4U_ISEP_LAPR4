package jobs4u.core.jobapplicationmanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewGradeTest {

    @Test
    void testValidInterviewGradeConstruction() {
        InterviewGrade interviewGrade = new InterviewGrade(80);
        assertEquals(80, interviewGrade.getValue());
    }

    @Test
    void testInvalidDownBoundInterviewGradeConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InterviewGrade(-10);
        });
    }

    @Test
    void testInvalidUpperBoundInterviewGradeConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InterviewGrade(107);
        });
    }


}