package jobs4u.persistence.impl.jpa;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jobs4u.Application;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.repositories.CustomerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Customer jpa repository.
 */
public class CustomerJpaRepository extends JpaAutoTxRepository<Customer, String, String> implements CustomerRepository {

    /**
     * Instantiates a new Customer jpa repository.
     *
     * @param autoTx the auto tx
     */
    public CustomerJpaRepository(final TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    /**
     * Instantiates a new Customer jpa repository.
     *
     * @param puname the puname
     */
    public CustomerJpaRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),"email");
    }

    @Override
    public Optional<Customer> findByEmail(Email email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.email = :email", params);
    }
}
