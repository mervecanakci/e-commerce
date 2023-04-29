package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
