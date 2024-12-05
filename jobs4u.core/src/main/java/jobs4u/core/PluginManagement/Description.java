package jobs4u.core.PluginManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Description {
    @Column(name = "description")
    private String value;

    protected Description() {
    }

    public Description(String value) {
        if (value == null || !value.matches("[a-zA-Z .]+")) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.value = value;
    }

    public static Description valueOf(String description) {
        return new Description(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description description = (Description) o;
        return Objects.equals(value, description.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
