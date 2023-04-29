package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.abstracts.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
