package kodlama.io.ecommerce.business.dto.responses.create;

import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse{
    private int id;
    private int categoryId;
    private String name;
    private int quantity; //miktar
    private double price;
    private double totalPrice;
    private LocalDateTime dateOfReceipt; // Fatura tarihi
    private String description;
    private State state; //stok durumu -->  IN_STOCK or OUT_OF_STOCK

}
