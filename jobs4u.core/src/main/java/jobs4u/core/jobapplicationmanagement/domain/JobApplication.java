package jobs4u.core.jobapplicationmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.interviewmanagement.domain.Interview;
import jobs4u.core.jobapplicationmanagement.dto.JobApplicationDTO;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Job application.
 */
@Entity
@XmlRootElement
@Getter
@Setter

public class JobApplication implements AggregateRoot<Long>, DTOable<JobApplicationDTO>, Representationable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    @ManyToOne
    private Candidate candidate;
    @ElementCollection
    private List<FileJobApp> file;

    @Enumerated(EnumType.STRING)
    private State state;

    private String rank;

    private java.util.Date date;


    private InterviewGrade interviewGrade;

    @ManyToOne
    @JoinColumn(name = "name")
    private JobOpening jobOpening;


    /**
     * Instantiates a new Job application.
     *
     * @param candidate  the candidate
     * @param file       the file
     * @param state      the state
     * @param rank       the rank
     * @param date       the date
     * @param jobOpening the job opening
     */
    public JobApplication( Candidate candidate, List<FileJobApp> file, State state, String rank, Date date, JobOpening jobOpening) {
        Preconditions.noneNull(candidate, file,state,rank,date,jobOpening);

        this.candidate = candidate;
        this.file = file;
        this.rank = rank;
        this.state = state;
        this.date = date;


    }

    /**
     * Instantiates a new Job application.
     *
     * @param candidate      the candidate
     * @param file           the file
     * @param state          the state
     * @param date           the date
     * @param jobOpening     the job opening
     * @param interviewGrade the interview grade
     */
    public JobApplication( Candidate candidate, List<FileJobApp> file, State state, Date date, JobOpening jobOpening, InterviewGrade interviewGrade) {
        Preconditions.noneNull(candidate, file,state,date,jobOpening);


        this.candidate = candidate;
        this.file = file;
        this.state = state;
        this.date = date;
        this.jobOpening = jobOpening;
        this.interviewGrade = interviewGrade;


    }

    /**
     * Instantiates a new Job application.
     *
     * @param candidate  the candidate
     * @param file       the file
     * @param state      the state
     * @param date       the date
     * @param jobOpening the job opening
     */
    public JobApplication( Candidate candidate, List<FileJobApp> file, State state, Date date, JobOpening jobOpening) {
        Preconditions.noneNull(candidate, file,state,date,jobOpening);


        this.candidate = candidate;
        this.file = file;
        this.state = state;
        this.date = date;
        this.jobOpening = jobOpening;


    }


    /**
     * Instantiates a new Job application.
     */
    public JobApplication() {
        // for ORM only.
    }

    /**
     * Update state based on verification result.
     *
     * @param verificationResult the verification result
     */
    public void updateStateBasedOnVerificationResult(int verificationResult) {
        if (verificationResult >= 0 && verificationResult <= 49) {
            this.state = State.REJECTED;
        } else if (verificationResult >= 50 && verificationResult <= 100) {
            this.state = State.CONFIRMED;
        } else {
            throw new IllegalArgumentException("Invalid verification result: " + verificationResult);
        }
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof JobApplication)) {
            return false;
        }

        final JobApplication that = (JobApplication) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public <R> R buildRepresentation(RepresentationBuilder<R> builder) {
        builder.startObject("JobApplication")
                .withProperty("ID", iD)
                .withProperty("Candidate", String.valueOf(candidate.getEmail()))
                .withProperty("filesUrl", file.stream()
                .map(FileJobApp::getValue)
                .collect(Collectors.joining(",")))
                .withProperty("rank", rank)
                .withProperty("state", state.getState())
                .withProperty("date", date.toString())
                .endObject();
        return builder.build();
    }


    @Override
    public JobApplicationDTO toDTO() { // CHANGE
        return new JobApplicationDTO(iD,candidate,file,state,rank,date,jobOpening,interviewGrade);
    }

    @Override
    public Long identity() {
        return this.iD;
    }
}
