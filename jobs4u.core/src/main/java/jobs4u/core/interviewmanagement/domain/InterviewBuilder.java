package jobs4u.core.interviewmanagement.domain;

import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;

import java.util.Date;

/**
 * The type Interview builder.
 */
public class InterviewBuilder {

    private Long id;
    private Date date;
    private String grade;
    private InterviewModel interviewModel;

    /**
     * With id interview builder.
     *
     * @param id the id
     * @return the interview builder
     */
    public InterviewBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With date interview builder.
     *
     * @param date the date
     * @return the interview builder
     */
    public InterviewBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * With grade interview builder.
     *
     * @param grade the grade
     * @return the interview builder
     */
    public InterviewBuilder withGrade(String grade) {
        this.grade = grade;
        return this;
    }

    /**
     * With interview model interview builder.
     *
     * @param interviewModel the interview model
     * @return the interview builder
     */
    public InterviewBuilder withInterviewModel(InterviewModel interviewModel) {
        this.interviewModel = interviewModel;
        return this;
    }

    /**
     * Build interview.
     *
     * @return the interview
     */
    public Interview build() {
        return new Interview(id, date, grade, interviewModel);
    }
}
