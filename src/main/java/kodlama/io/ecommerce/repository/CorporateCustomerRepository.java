package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {
}
