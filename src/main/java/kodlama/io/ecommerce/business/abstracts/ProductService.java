package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.entities.enums.State;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll(boolean includeOutOfStock);
    // false gelirse stokta olmayan ürünleri getirmeyecek
    // true gelirse(default olarak true) hepsini getiricek
    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(int id, UpdateProductRequest request);

    void delete(int id);

    void changeState(int productId, State state);
}
//todo servis kısmı tamam

