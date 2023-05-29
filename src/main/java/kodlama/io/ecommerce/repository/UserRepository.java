package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailIgnoreCase(String email);
}
