package jobs4u.core.jobapplicationmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


/**
 * This class represents an Interview Grade in the job application management domain.
 * It is marked as Embeddable, which means it is not an entity but it can be embedded in an entity.
 * It has a single field, value, which represents the interview grade.
 */
@Embeddable
public class InterviewGrade {

    // The value of the interview grade
    @Column(name = "interview_grade")
    private Integer value;

    /**
     * Default constructor required by JPA.
     * It is protected to prevent direct instantiation.
     */
    protected InterviewGrade() {
    }

    /**
     * Constructor for InterviewGrade.
     * It validates the input and throws an IllegalArgumentException if the input is null or out of the range 0-10.
     *
     * @param value The interview grade.
     * @throws IllegalArgumentException if the input is null or out of the range 0-10.
     */
    public InterviewGrade(Integer value) {
        if (value == null || value < 0 || value > 100) {
            throw new IllegalArgumentException("Invalid interview grade. Must be between 0 and 100.");
        }
        this.value = value;
    }

    /**
     * Overrides the equals method from Object.
     * Two InterviewGrade objects are considered equal if their value fields are equal.
     *
     * @param o The object to compare this InterviewGrade to.
     * @return true if the given object is an InterviewGrade with the same value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewGrade interviewGrade = (InterviewGrade) o;
        return value.equals(interviewGrade.value);
    }

    /**
     * Overrides the hashCode method from Object.
     * The hash code of an InterviewGrade object is the hash code of its value field.
     *
     * @return The hash code of the value field.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Overrides the toString method from Object.
     * The string representation of an InterviewGrade object includes its value field.
     *
     * @return A string representation of this InterviewGrade.
     */
    @Override
    public String toString() {
        return "InterviewGrade - " +
                "\n\t Value = " + value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Integer getValue() {
        return this.value;
    }
}

