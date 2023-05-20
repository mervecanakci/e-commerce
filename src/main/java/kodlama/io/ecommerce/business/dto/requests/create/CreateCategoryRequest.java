package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {
    @NotBlank
    @Length(min = 2, message = "Length must be greater than 2..")
    private String name;
}
//todo tamam