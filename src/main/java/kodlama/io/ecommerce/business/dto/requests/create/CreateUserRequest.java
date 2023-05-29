package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.common.constants.Regex;
import kodlama.io.ecommerce.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank
    @Pattern(regexp = Regex.EmailRegex, message = Messages.User.EmailNotValid)
    private String email;
    @NotBlank
    @Length(min = 8, message = "Length must be greater than 8")
    private String password;

    private Role role;
}
//todo tamam