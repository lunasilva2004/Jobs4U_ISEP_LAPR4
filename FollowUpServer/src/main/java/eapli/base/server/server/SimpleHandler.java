package eapli.base.server.server;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import jobs4u.app.common.console.application.LoginController;
import jobs4u.app.common.console.application.LoginControllerImpl;
import jobs4u.core.candidateusermanagement.domain.Candidate;
import jobs4u.core.candidateusermanagement.repositories.CandidateRepository;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.jobapplicationmanagement.application.ListJobApplicationController;
import jobs4u.core.jobapplicationmanagement.application.ListNotificationJobApplicationController;
import jobs4u.core.jobopeningmanagement.application.ListJobOpeningController;
import jobs4u.core.serverManagement.domain.MessageCode;
import jobs4u.core.serverManagement.domain.Translator;
import jobs4u.core.usermanagement.domain.BasePasswordPolicy;
import jobs4u.core.usermanagement.domain.BaseRoles;
import jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import jobs4u.infrastructure.authz.CredentialHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Simple handler.
 */
public class SimpleHandler extends Handler {

    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    /**
     * Instantiates a new Simple handler.
     *
     * @param socket the socket
     * @throws IOException the io exception
     */
    public SimpleHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        System.out.println("\nConnection Established!");
        System.out.printf("Server Connetions: (%d/%d)\n", SemaphoreForServer.instance().availablePermits(), SemaphoreForServer.instance().getMaxPermits());
        boolean connected = true;

        Candidate candidate = null;
        Customer customer = null;

        do {
            try {
                byte[] message = (byte[]) this.sIn.readObject();
                int code = Translator.decodeCode(message);
                switch (code) {
                    case 0:
                        sendACK();
                        break;
                    case 1:
                        connected = false;
                        break;
                    case 4:
                        boolean authenticated = authenticate(message);
                        if (authenticated) {
                            String userEmail = new String(Objects.requireNonNull(Translator.decodeData1(message)));
                            Email email = new Email(userEmail);
                            System.out.println(userEmail);

                            Optional<Candidate> candidateOptional = candidateRepository.findByEmail(email);
                            if (candidateOptional.isPresent()) {
                                candidate = candidateOptional.get();
                            }

                            Optional<Customer> customerOptional = customerRepository.findByEmail(email);
                            if (customerOptional.isPresent()) {
                                customer = customerOptional.get();
                            }


                            sendACK();
                        } else {
                            sendERR();
                        }
                        break;
                    case 5:
                        ListJobApplicationController ctrlA = new ListJobApplicationController();
                        List<String> applicationsList = ctrlA.listJobApplicationsForCandidate();
                        sendSHOW_JOB_APPLICATIONS(applicationsList);
                        break;
                    case 7:
                        ListJobOpeningController crtlO = new ListJobOpeningController();
                        List<String> openingsList = crtlO.listJobOpeningsForCustomer();
                        sendSHOW_JOB_OPENINGS(openingsList);
                        break;

                    case 9:
                        ListNotificationJobApplicationController ctrlNA = new ListNotificationJobApplicationController();
                        List<String> notifApplicationsList = ctrlNA.listNotificationJobApplications();
                        sendSHOW_NOTIF_JOB_APPLICATIONS(notifApplicationsList);
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } while (connected);


        System.out.println("\nConnection Closed!");
        System.out.printf("Server Connetions: (%d/%d)\n", SemaphoreForServer.instance().availablePermits() - 1, SemaphoreForServer.instance().getMaxPermits());
        sendACK();
    }


    private boolean authenticate(byte[] message) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        String userEmail = new String(Objects.requireNonNull(Translator.decodeData1(message)));
        String password = new String(Objects.requireNonNull(Translator.decodeData2(message)));

        LoginController controller = new LoginControllerImpl();
        CredentialHandler authHandler = new AuthenticationCredentialHandler();

        String userName;

        System.out.println(userEmail);
        System.out.println(password);


        if ((userName = controller.findUsernameByEmail(userEmail)) != null
                && authHandler.authenticated(userName, password, BaseRoles.CANDIDATE)) {
            return true;
        }
        if ((userName = controller.findUsernameByEmail(userEmail)) != null
                && authHandler.authenticated(userName, password, BaseRoles.CUSTOMER)) {
            return true;
        }
        return false;
    }


    private void sendACK() {
        try {
            byte[] message = Translator.encode(1, MessageCode.ACK, null, null);
            this.sOut.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendERR() {
        try {
            this.sOut.writeObject(Translator.encode(1, MessageCode.ERR, null, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendSHOW_JOB_OPENINGS(List<String> list) {
        try {
            byte[] data = Translator.serializeListJobOpenings(list);
            this.sOut.writeObject(Translator.encode(1, MessageCode.SHOW_JOB_OPENINGS, data, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendSHOW_JOB_APPLICATIONS(List<String> list) {
        try {
            byte[] data = Translator.serializeListJobApplications(list);
            this.sOut.writeObject(Translator.encode(1, MessageCode.SHOW_JOB_APPLICATIONS, data, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendSHOW_NOTIF_JOB_APPLICATIONS(List<String> list) {
        try {
            byte[] data = Translator.serializeNotificationJobApplication(list);
            this.sOut.writeObject(Translator.encode(1, MessageCode.SHOW_NOTIF_JOB_APPLICATIONS, data, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
