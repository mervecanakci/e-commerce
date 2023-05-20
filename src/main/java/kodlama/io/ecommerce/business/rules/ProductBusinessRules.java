package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.entities.enums.State;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ProductBusinessRules {
    private final ProductRepository repository;

    //! Business Rules
    public void validateProduct(Product product) {
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionValid(product);
    }

    public void checkIfPriceValid(Product product) {
        if (product.getPrice() <= 0) throw new
                IllegalArgumentException("Price cannot be less than or equal to zero.");

    }

    public void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new
                IllegalArgumentException("Quantity cannot be less than zero.");

    }
    public void checkIfDescriptionValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50) throw new
                IllegalArgumentException("Descriptions length must be between 10 and 50 character");
    }
    public void checkIfProductExists(int id){
        if(!repository.existsById(id)) throw  new RuntimeException("Ürün bulunamadı!");
    }

    public void checkIfProductIsInStock(State state) {
        if (!state.equals(State.IN_STOCK)) {
            throw new BusinessException(Messages.Product.NotInStock);
        }
    }
}
