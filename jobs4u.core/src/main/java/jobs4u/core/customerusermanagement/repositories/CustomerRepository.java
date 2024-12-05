package jobs4u.core.customerusermanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import jobs4u.core.customerusermanagement.domain.Customer;
import jobs4u.core.customerusermanagement.domain.Email;

import java.util.Optional;

/**
 * This interface represents a repository for Customer objects in the customer user management domain.
 * It extends the DomainRepository interface with the identity being the email of the customer and the entity being the Customer.
 * It provides a method for finding a Customer by its email.
 */
public interface CustomerRepository extends DomainRepository<String, Customer> {

    /**
     * Finds a Customer by its email.
     *
     * @param email The email of the customer to find.
     * @return An Optional containing the found Customer if it exists, empty otherwise.
     */
    Optional<Customer> findByEmail(Email email);

}