/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.app.backoffice.console;

import jobs4u.app.backoffice.console.presentation.MainMenu;
import jobs4u.app.common.console.BaseApplication;
import jobs4u.app.common.console.presentation.authz.LoginUI;
import jobs4u.core.clientusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import jobs4u.core.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import jobs4u.core.clientusermanagement.domain.events.SignupAcceptedEvent;
import jobs4u.infrastructure.authz.AuthenticationCredentialHandler;
import jobs4u.core.infrastructure.persistence.PersistenceContext;
import jobs4u.core.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import jobs4u.core.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The type Backoffice app.
 *
 * @author Paulo Gandra Sousa
 */
@SpringBootApplication
@EnableScheduling
public class BackofficeApp extends BaseApplication {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        SpringApplication.run(BackofficeApp.class, args);
        new BackofficeApp().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        // login and go to main menu
        if (new LoginUI(new AuthenticationCredentialHandler()).show()) {
            // go to main menu
            final MainMenu menu = new MainMenu();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Welcome to Jobs4U BackOffice App";
    }

    @Override
    protected String appGoodbye() {
        return "Greetings from the team Jobs4U BackOffice";
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(),
                NewUserRegisteredFromSignupEvent.class);
        dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
        //dispatcher.subscribe(new JobOpeningAcceptedWatchDog(), JobOpeningAcceptedEvent.class);
    }
}
