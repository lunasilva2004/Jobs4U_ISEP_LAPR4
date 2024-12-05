package jobs4u.core.jobopeningmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * The type Job opening phase.
 */
@Entity
@Getter
@Setter
public class JobOpeningPhase implements ValueObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PhaseType phaseType;

    @Setter
    private Date startDate;
    @Setter
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "job_opening_id")
    private JobOpening jobOpening;

    /**
     * Instantiates a new Job opening phase.
     *
     * @param phaseType  the phase type
     * @param startDate  the start date
     * @param endDate    the end date
     * @param jobOpening the job opening
     */
    public JobOpeningPhase(PhaseType phaseType, Date startDate, Date endDate, JobOpening jobOpening) {
        Preconditions.noneNull(phaseType, jobOpening, startDate, endDate);
        this.phaseType = phaseType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobOpening = jobOpening;
    }

    /**
     * Instantiates a new Job opening phase.
     */
    protected JobOpeningPhase() {
        // for ORM only
    }

    @Override
    public String toString() {
        return "JobOpeningPhase{" +
                "phaseType=" + phaseType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
