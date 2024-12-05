package jobs4u.core.interviewmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jobs4u.core.PluginManagement.InterviewModelManagement.domain.InterviewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

/**
 * The type Interview.
 */
@Entity
@Getter
@Setter
public class Interview implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private String grade;

    @ManyToOne
    private InterviewModel interviewModel;

    /**
     * Instantiates a new Interview.
     *
     * @param id             the id
     * @param date           the date
     * @param grade          the grade
     * @param interviewModel the interview model
     */
    public Interview(Long id, Date date, String grade, InterviewModel interviewModel) {
        this.id = id;
        this.date = date;
        this.grade = grade;
        this.interviewModel = interviewModel;
    }

    /**
     * Instantiates a new Interview.
     */
    public Interview() {
        //For ORM only
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Interview)) {
            return false;
        }

        final Interview that = (Interview) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    /**
     * Update interview model.
     *
     * @param interviewModel the interview model
     */
    @Transactional
    public void updateInterviewModel(InterviewModel interviewModel) {
        this.interviewModel = interviewModel;
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(id, interview.id) && Objects.equals(date, interview.date) && Objects.equals(grade, interview.grade) && Objects.equals(interviewModel, interview.interviewModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, grade, interviewModel);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", grade='" + grade + '\'' +
                ", interviewModel=" + interviewModel +
                '}';
    }
}
