package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.persons.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
