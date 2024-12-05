package jobs4u.core.PluginManagement;
import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class FQClassName implements ValueObject, Comparable<FQClassName>, StringMixin {

    private static final long serialVersionUID = 1L;

    @XmlAttribute
    @JsonProperty
    private final String fqClassName;

    public FQClassName(final String name) {
        Preconditions.nonEmpty(name);

        // Check if it is a FQName
        if (!name.matches("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*")) {
            throw new IllegalArgumentException("Invalid fully qualified class name");
        }

        this.fqClassName = name;
    }

    protected FQClassName() {
        // for ORM
        fqClassName = null;
    }

    public static FQClassName valueOf(final String fqClassName) {
        return new FQClassName(fqClassName);
    }

    @Override
    public String toString() {
        return fqClassName;
    }

    @Override
    public int compareTo(final FQClassName o) {
        return fqClassName.compareTo(o.fqClassName);
    }
}