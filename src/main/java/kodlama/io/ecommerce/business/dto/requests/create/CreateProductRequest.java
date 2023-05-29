package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kodlama.io.ecommerce.business.dto.requests.PaymentRequest;
import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotNull
    private int categoryId;

    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull
    private int quantity; //miktar
    @NotNull
    @Min(0)
    private double price;
    @NotNull
    private boolean isActive;
    @NotBlank
    private String description;
    private State state;


//todo tamam


}
