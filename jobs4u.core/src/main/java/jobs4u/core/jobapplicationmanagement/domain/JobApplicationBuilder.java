package jobs4u.core.jobapplicationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;

import java.util.Date;
import java.util.List;

/**
 * The type Job application builder.
 */
public class JobApplicationBuilder implements DomainFactory<JobApplication> {


    private String iD;
    private Candidate candidate;

    private List<FileJobApp> file;

    private State state;

    private String rank;

    private java.util.Date date;

    private JobOpening jobOpening;

    private InterviewGrade interviewGrade;

    /**
     * With interview grade job application builder.
     *
     * @param interviewGrade the interview grade
     * @return the job application builder
     */
    public JobApplicationBuilder withInterviewGrade(InterviewGrade interviewGrade) {
        this.interviewGrade= interviewGrade;
        return this;
    }

    /**
     * With job opening job application builder.
     *
     * @param jobOpening the job opening
     * @return the job application builder
     */
    public JobApplicationBuilder withJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
        return this;
    }

    /**
     * With state job application builder.
     *
     * @param state the state
     * @return the job application builder
     */
    public JobApplicationBuilder withState(State state) {
        this.state = state;
        return this;
    }

    /**
     * With date job application builder.
     *
     * @param date the date
     * @return the job application builder
     */
    public JobApplicationBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * Withrank job application builder.
     *
     * @param rank the rank
     * @return the job application builder
     */
    public JobApplicationBuilder withrank(String rank) {
        this.rank = rank;
        return this;
    }


    /**
     * Withi d job application builder.
     *
     * @param iD the d
     * @return the job application builder
     */
    public JobApplicationBuilder withiD(String iD) {
        this.iD = iD;
        return this;
    }


    /**
     * With candidate job application builder.
     *
     * @param candidate the candidate
     * @return the job application builder
     */
    public JobApplicationBuilder withCandidate(Candidate candidate) {
        this.candidate = candidate;
        return this;
    }


    /**
     * Withfile job application builder.
     *
     * @param file the file
     * @return the job application builder
     */
    public JobApplicationBuilder withfile(List<FileJobApp> file) {
        this.file = file;
        return this;
    }

    @Override
    public JobApplication build() {return new JobApplication(candidate, file, state, date, jobOpening);}


}
