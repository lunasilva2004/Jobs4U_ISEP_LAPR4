package jobs4u.core.serverManagement.domain;

/**
 * The enum Message code.
 */
public enum MessageCode {
    /**
     * Commtest message code.
     */
    COMMTEST(0),
    /**
     * Disconn message code.
     */
    DISCONN(1),
    /**
     * Ack message code.
     */
    ACK(2),
    /**
     * Err message code.
     */
    ERR(3),
    /**
     * Auth message code.
     */
    AUTH(4),
    /**
     * List job applications message code.
     */
    LIST_JOB_APPLICATIONS(5),
    /**
     * Show job applications message code.
     */
    SHOW_JOB_APPLICATIONS(6),
    /**
     * List job openings message code.
     */
    LIST_JOB_OPENINGS(7),
    /**
     * Show job openings message code.
     */
    SHOW_JOB_OPENINGS(8),

    /**
     * List notif job applications message code.
     */
    LIST_NOTIF_JOB_APPLICATIONS(9),

    /**
     * Show notif job applications message code.
     */
    SHOW_NOTIF_JOB_APPLICATIONS(10);
    private final int code;

    MessageCode(int code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}