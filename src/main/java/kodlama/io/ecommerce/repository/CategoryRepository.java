package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
