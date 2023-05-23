package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
private final UserRepository repository;
    public void checkIfUserExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.User.NotExists);
        }
    }
    public void checkIfUserExistsByEmail(String email) {
        if (repository.existsByEmailIgnoreCase(email)) {
            throw new BusinessException(Messages.User.Exists);
        }
    }
}
