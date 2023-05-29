package kodlama.io.ecommerce.business.dto.responses.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kodlama.io.ecommerce.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
    private int id;
    private String name;
    private double price;
    @NotNull
    private int amount; //miktar
    private double totalPrice;
    @NotBlank
    private PaymentRequest paymentRequest; // kart bilgileri
}
