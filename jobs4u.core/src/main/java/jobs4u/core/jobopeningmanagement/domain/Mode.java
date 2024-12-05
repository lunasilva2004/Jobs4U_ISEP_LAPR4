package jobs4u.core.jobopeningmanagement.domain;

/**
 * The enum Mode.
 */
public enum Mode {

    /**
     * Remote mode.
     */
    REMOTE("Remote"),
    /**
     * Hybrid mode.
     */
    HYBRID("Hybrid"),
    /**
     * Onsite mode.
     */
    ONSITE("Onsite");

    private final String displayMode;

    Mode(String displayMode) {
        this.displayMode = displayMode;
    }

    /**
     * Gets mode.
     *
     * @return the mode
     */
    public String getMode() {
        return displayMode;
    }

}
