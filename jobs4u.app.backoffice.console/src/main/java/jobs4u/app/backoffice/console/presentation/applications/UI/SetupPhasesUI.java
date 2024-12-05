package jobs4u.app.backoffice.console.presentation.applications.UI;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.jobopeningmanagement.application.SetupPhasesController;
import jobs4u.core.jobopeningmanagement.domain.JobOpening;
import jobs4u.core.jobopeningmanagement.domain.PhaseType;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Setup phases ui.
 */
public class SetupPhasesUI extends AbstractUI {

    private final SetupPhasesController setupPhasesController = new SetupPhasesController();

    @Override
    protected boolean doShow() {
        Iterable<JobOpening> jobOpenings = setupPhasesController.listJobOpenings();
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpenings.forEach(jobOpeningList::add);

        for (int i = 0; i < jobOpeningList.size(); i++) {
            System.out.println((i + 1) + ". " + jobOpeningList.get(i).toDTO().getJobReference());
        }

        System.out.println("Por favor, selecione uma Job Opening:");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        JobOpening selectedJobOpening = jobOpeningList.get(index - 1);

        System.out.println("Deseja adicionar a fase de entrevistas? (s/n)");
        String addInterviews = scanner.next();

        System.out.println("As fases que serão adicionadas são:");
        for (PhaseType phaseType : PhaseType.values()) {
            if (phaseType == PhaseType.INTERVIEWS && !addInterviews.equalsIgnoreCase("s")) {
                continue;
            }
            System.out.println(phaseType.name());
        }

        System.out.println("Deseja continuar? (s/n)");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("s")) {
            for (PhaseType phaseType : PhaseType.values()) {
                if (phaseType == PhaseType.INTERVIEWS && !addInterviews.equalsIgnoreCase("s")) {
                    continue;
                }

                System.out.println("Definindo datas para a fase: " + phaseType.name());

                System.out.println("Por favor, insira a data de início (formato yyyy-mm-dd):");
                String startDateInput = scanner.next();
                LocalDate startDate = LocalDate.parse(startDateInput);

                System.out.println("Por favor, insira a data de fim (formato yyyy-mm-dd):");
                String endDateInput = scanner.next();
                LocalDate endDate = LocalDate.parse(endDateInput);

                setupPhasesController.addPhasesToJobOpening(selectedJobOpening.toDTO().getJobReference(), phaseType, Date.valueOf(startDate), Date.valueOf(endDate));
            }
        } else {
            System.out.println("Operação cancelada.");
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Setup Phases";
    }
}