package jobs4u.core.candidateusermanagement.domain;

import eapli.framework.representations.dto.DTO;
import jobs4u.core.customerusermanagement.domain.Email;
import jobs4u.core.customerusermanagement.domain.Name;
import jobs4u.core.customerusermanagement.domain.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Candidate dto.
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private Name name;
    private Email email;
    private PhoneNumber phoneNumber;
}
