package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //custom queries
    List<Product> findAllByStateIsNot(State state);
    // state i hangi durumda istemiyorsan o durumu dışlayacak ve diğer durumları getirecek
    //productManager.getAll da yapıyoruz bu filtreleme işlemini


}
