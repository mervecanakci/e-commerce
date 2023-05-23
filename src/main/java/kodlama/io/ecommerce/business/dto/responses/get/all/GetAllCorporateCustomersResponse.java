package kodlama.io.ecommerce.business.dto.responses.get.all;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCorporateCustomersResponse {
    private int id;
    private String name;
    private String taxNumber;
    private double point;
}

