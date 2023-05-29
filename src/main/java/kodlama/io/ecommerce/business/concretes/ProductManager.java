package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.InvoiceService;
import kodlama.io.ecommerce.business.abstracts.PaymentService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.ecommerce.business.rules.ProductBusinessRules;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.entities.enums.State;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductManager implements ProductService {

    private final ProductBusinessRules rules;
    private final ModelMapper mapper;
    private final ProductRepository repository;


    @Override
    public List<GetAllProductsResponse> getAll(boolean includeOutOfStock) {
        List<Product> products = filterProductsState(includeOutOfStock);
        // daha okunaklı olması için yazman daha iyi olur
        List<GetAllProductsResponse> response = products
                //mapper la döndürmek istediğimiz tip : GetAllProductsResponse
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                // sonra her bir Product için (Product ->) mapper ı çağır
                //map de Productin her birini GetAllProductsResponse a çevir
                .toList();  // bunu listeye çevir

        return response;
    }


    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);

        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        rules.checkIfProductIsInStock(request.getState());
        Product product = mapper.map(request, Product.class); //requestten geleni mapledik

        product.setActive(true);
        //? rules.validateProduct(product);
        //? rules.checkIfProductExistsByName(request.getName());
        product.setId(0); //yeni bir tane oluştur create anlamında date base i 1 den başlat
        //dto kaynaklı bu gerekli diğer id ile karıştırabilir
        product.setState(State.IN_STOCK);



        repository.save(product);

        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);



        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        rules.validateProduct(product);

        product.setId(id);
        product.setTotalPrice(getTotalPrice(product));
        changeState(id, State.IN_STOCK);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExists(id);
        int productId = repository.findById(id).get().getId();
        changeState(productId, State.OUT_OF_STOCK);
        repository.deleteById(id);
    }

    @Override
    public void changeState(int productId, State state) {
        Product product = repository.findById(productId).orElseThrow();
        product.setState(state);
        repository.save(product);
    }

    private List<Product> filterProductsState(boolean includeOutOfStock) {
        // includeMaintenance ; stokta olmayanları  dahil edeyim mi diyor
        //true ise hepsini getir
        if (includeOutOfStock) {
            return repository.findAll();
        }
        // false ise stokta olmayanı çıkarıp diğerlerini getiricek
        return repository.findAllByStateIsNot(State.OUT_OF_STOCK);
    }

    private double getTotalPrice(Product product) {
        return product.getPrice() * product.getQuantity();
    }

//todo

    /*

    public void setActive(){
        this.status=Status.IN_STOCK;
    }
    public void setNotActive(){
        this.status=Status.OUT_OF_STOCK;
    }
     */

}
