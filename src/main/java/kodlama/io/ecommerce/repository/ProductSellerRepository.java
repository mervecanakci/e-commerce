package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.abstracts.ProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSellerRepository extends JpaRepository<ProductSeller, Integer> {
}
