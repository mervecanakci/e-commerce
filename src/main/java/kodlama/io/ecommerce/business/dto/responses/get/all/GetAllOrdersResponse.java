package kodlama.io.ecommerce.business.dto.responses.get.all;

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
public class GetAllOrdersResponse {
    private int id;
    private double price;
    private String name;
    @NotNull
    private int amount; //miktar
    private double totalPrice;
    @NotBlank
    private PaymentRequest paymentRequest; // kart bilgileri
}
