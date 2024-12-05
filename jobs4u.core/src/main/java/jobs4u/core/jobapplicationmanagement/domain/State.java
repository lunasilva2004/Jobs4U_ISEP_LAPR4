package jobs4u.core.jobapplicationmanagement.domain;

/**
 * The enum State.
 */
public enum State {

    /**
     * Pending state.
     */
    PENDING("Pending"),

    /**
     * Confirmed state.
     */
    CONFIRMED("Confirmed"),

    /**
     * Rejected state.
     */
    REJECTED("Rejected");


    private final String displayState;

    State(String displayMode) {
        this.displayState = displayMode;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return displayState;
    }

}
