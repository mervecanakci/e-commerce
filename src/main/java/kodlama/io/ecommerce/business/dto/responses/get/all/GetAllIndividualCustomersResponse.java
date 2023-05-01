package kodlama.io.ecommerce.business.dto.responses.get.all;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllIndividualCustomersResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int birthYear;
}

