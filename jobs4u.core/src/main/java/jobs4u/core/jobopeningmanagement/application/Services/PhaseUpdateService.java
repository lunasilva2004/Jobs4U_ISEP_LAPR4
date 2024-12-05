package jobs4u.core.jobopeningmanagement.application.Services;

import jobs4u.core.jobopeningmanagement.application.ManagePhasesController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * The type Phase update service.
 */
@Service
@Component
public class PhaseUpdateService {

    private final ManagePhasesController managePhasesController;

    /**
     * Instantiates a new Phase update service.
     *
     * @param managePhasesController the manage phases controller
     */
    public PhaseUpdateService(ManagePhasesController managePhasesController) {
        this.managePhasesController = managePhasesController;
    }

    /**
     * Update phases.
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void updatePhases() {
        System.out.println("Running scheduled task: updatePhases");
        managePhasesController.updatePhasesBasedOnDate();
    }
}