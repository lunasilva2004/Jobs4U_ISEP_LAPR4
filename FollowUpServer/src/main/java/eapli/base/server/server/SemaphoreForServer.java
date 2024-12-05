package eapli.base.server.server;

import java.util.Properties;
import java.util.concurrent.Semaphore;

/**
 * The type Semaphore for server.
 */
public class SemaphoreForServer {

    private static SemaphoreForServer instance;
    private final Semaphore semaphore;

    private SemaphoreForServer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * Instance semaphore for server.
     *
     * @return the semaphore for server
     */
    public static SemaphoreForServer instance() {
        if (instance == null) {
            synchronized (SemaphoreForServer.class) {
                Properties props = System.getProperties();
                instance = new SemaphoreForServer(new Semaphore(Integer.parseInt(props.getOrDefault("server.connections.max", 10).toString())));
            }
        }
        return instance;
    }


    /**
     * Activate critical section boolean.
     *
     * @return the boolean
     * @throws InterruptedException the interrupted exception
     */
    public boolean activateCriticalSection() throws InterruptedException {
        return this.semaphore.tryAcquire();
    }

    /**
     * Deactivate critical section.
     */
    public void deactivateCriticalSection() {
        this.semaphore.release();
    }

    /**
     * Available permits int.
     *
     * @return the int
     */
    public int availablePermits() {
        int maxPermits = getMaxPermits();
        int availablePermits = this.semaphore.availablePermits();
        return maxPermits - availablePermits;
    }

    /**
     * Gets max permits.
     *
     * @return the max permits
     */
    public int getMaxPermits() {
        Properties props = System.getProperties();
        return Integer.parseInt(props.getOrDefault("server.connections.max", 5).toString());
    }


}
