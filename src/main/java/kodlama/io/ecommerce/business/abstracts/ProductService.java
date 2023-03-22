package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(int id,Product product);
    //nesne silmek için delete yazılıyor
    //nesne silindiğinde de bir şey döndürülmez ondan sadece void
    void delete(int id);
}
