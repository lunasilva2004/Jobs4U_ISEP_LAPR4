/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.core.clientusermanagement.domain.events;

import jobs4u.core.clientusermanagement.domain.MecanographicNumber;
import jobs4u.core.clientusermanagement.domain.SignupRequest;
import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Username;
import jobs4u.core.clientusermanagement.domain.MecanographicNumber;
import jobs4u.core.clientusermanagement.domain.SignupRequest;

/**
 * The type Signup accepted event.
 *
 * @author Paulo Gandra de Sousa
 */
public class SignupAcceptedEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final SignupRequest theSignupRequest;

    /**
     * Instantiates a new Signup accepted event.
     *
     * @param theSignupRequest the the signup request
     */
    public SignupAcceptedEvent(final SignupRequest theSignupRequest) {
        this.theSignupRequest = theSignupRequest;
    }

    /**
     * Username username.
     *
     * @return the username
     */
    public Username username() {
        return theSignupRequest.username();
    }

    /**
     * Password password.
     *
     * @return the password
     */
    public Password password() {
        return theSignupRequest.password();
    }

    /**
     * Name name.
     *
     * @return the name
     */
    public Name name() {
        return theSignupRequest.name();
    }

    /**
     * Email email address.
     *
     * @return the email address
     */
    public EmailAddress email() {
        return theSignupRequest.email();
    }

    /**
     * Mecanographic number mecanographic number.
     *
     * @return the mecanographic number
     */
    public MecanographicNumber mecanographicNumber() {
        return theSignupRequest.mecanographicNumber();
    }

    @Override
    public String toString() {
        return "SignupAccepted(" + username() + ")";
    }
}
