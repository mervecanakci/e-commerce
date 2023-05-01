package kodlama.io.ecommerce.business.dto.responses.get.all;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomersResponse {
    private int id;
    private LocalDateTime dateRegistered;
}
