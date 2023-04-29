package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.persons.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}
