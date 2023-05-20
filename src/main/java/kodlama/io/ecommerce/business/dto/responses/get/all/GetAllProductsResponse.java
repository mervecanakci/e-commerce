package kodlama.io.ecommerce.business.dto.responses.get.all;

import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductsResponse {
    private int id;
    private int categoryId;
    private String name;
    private int quantity; //miktar
    private double price;
    private double totalPrice;
    private String description;
    private State state; //stok durumu -->  IN_STOCK or OUT_OF_STOCK

    //TODO ORDER CUSTOMER YAZILACAK MI
}
