package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.jobapplicationmanagement.application.RegisterJobApplicationController;
import jobs4u.core.jobapplicationmanagement.domain.FileJobApp;
import jobs4u.core.jobapplicationmanagement.domain.State;

import java.io.*;
import java.sql.Date;
import java.util.*;


/**
 * The type Register application ui.
 */
public class RegisterApplicationUI extends AbstractUI {


    private final RegisterJobApplicationController theController = new RegisterJobApplicationController();


    @Override
    protected boolean doShow() {

        final String sharedFolderPath = Console.readNonEmptyLine("Shared Folder", "Please enter the shared folder");
        final String emailCandidate = Console.readNonEmptyLine("Candidate email", "Please enter the candidate email");

        File pasta = new File(sharedFolderPath);
        Map<String, String> txtFilesMap = new HashMap<>();

        if (pasta.isDirectory()) {
            File[] subPastas = pasta.listFiles((dir, name) -> name.contains("output"));
            if (subPastas != null && subPastas.length > 0) {
                for (File outputDir : subPastas) {
                    if (outputDir.isDirectory()) {
                        File[] arquivos = outputDir.listFiles();
                        if (arquivos != null) {
                            for (File arquivo : arquivos) {
                                if (arquivo.isDirectory()) {
                                    File[] subArquivos = arquivo.listFiles();
                                    if (subArquivos != null) {
                                        for (File subArquivo : subArquivos) {
                                            if (subArquivo.isDirectory()) {

                                                String candidatePath = subArquivo.getName() + "-candidate-data.txt";
                                                File arquivoDados = new File(subArquivo, candidatePath);
                                                try (Scanner scanner = new Scanner(arquivoDados)) {
                                                    String jobReference = scanner.nextLine();
                                                    String email = scanner.nextLine();
                                                    String nomeCompleto = scanner.nextLine();
                                                    String[] nomeSeparado = nomeCompleto.split(" ");
                                                    String primeiroNome = nomeSeparado[0];
                                                    String ultimoNome = nomeSeparado[1];
                                                    String phoneNumber = scanner.nextLine();
                                                    String id = "Application " + subArquivo.getName() + " - " + jobReference;


                                                    if (email.equals(emailCandidate)) {
                                                        File[] txtFiles = subArquivo.listFiles((dir, name) -> name.endsWith(".txt"));
                                                        if (txtFiles != null) {
                                                            for (File txtFile : txtFiles) {
                                                                txtFilesMap.put(txtFile.getName(), txtFile.getPath());
                                                            }
                                                        }

                                                        List<FileJobApp> fileJobApps = new ArrayList<>();
                                                        for (Map.Entry<String, String> entry : txtFilesMap.entrySet()) {
                                                            fileJobApps.add(new FileJobApp(entry.getValue()));
                                                        }
                                                        try {

                                                            this.theController.registerJobApplication(Designation.valueOf(jobReference), email, id, fileJobApps, State.PENDING, primeiroNome, ultimoNome, phoneNumber);
                                                            System.out.println("\nJob Application created successfully.\n");
                                                        } catch (final IllegalArgumentException | IllegalStateException e) {
                                                            System.out.println("Error creating Job Application: " + e.getMessage());
                                                        }
                                                    }
                                                } catch (FileNotFoundException e) {
                                                    System.out.println("Arquivo candidate-data.txt não encontrado no subdiretório: " + subArquivo.getName());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("O caminho não representa um diretório válido.");
        }



        return false;
}


    private Date readDate(String prompt) {
        String dateStr;
        Date date = null;

        while (date == null) {
            dateStr = Console.readNonEmptyLine(prompt, "Please enter the date");

            if (!dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }else {
                date = Date.valueOf(dateStr);
            }


        }
        return date;
    }

    @Override
    public String headline() {
        return "Register a Job Application";
    }

}
