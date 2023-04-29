package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Integer> {
}
