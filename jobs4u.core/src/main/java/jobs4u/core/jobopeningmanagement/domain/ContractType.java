package jobs4u.core.jobopeningmanagement.domain;

/**
 * The enum Contract type.
 */
public enum ContractType {

    /**
     * The Full time.
     */
    FULL_TIME("Full Time"),
    /**
     * The Part time.
     */
    PART_TIME("Part Time");

    private final String displayName;

    ContractType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return displayName;
    }
}
