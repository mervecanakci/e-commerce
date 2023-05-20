package kodlama.io.ecommerce.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIndividualCustomersResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int birthYear;
}
