package jobs4u.core.customerusermanagement.domain;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Customer dto.
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Name name;
    private Email email;
    private PhoneNumber phoneNumber;
    private Address address;
}
