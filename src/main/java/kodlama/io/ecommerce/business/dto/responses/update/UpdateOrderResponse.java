package kodlama.io.ecommerce.business.dto.responses.update;

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
public class UpdateOrderResponse {
    private int id;
    private double price;
    @NotNull
    private int amount; //miktar

    @NotBlank
    private PaymentRequest paymentRequest; // kart bilgileri
}
