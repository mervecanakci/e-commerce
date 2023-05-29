package kodlama.io.ecommerce.business.dto.responses.create;

import kodlama.io.ecommerce.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private int id;
    private String email;
    private String password;
    private Role role;
}
