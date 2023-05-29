package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kodlama.io.ecommerce.business.dto.requests.PaymentRequest;
import kodlama.io.ecommerce.common.dto.CreateProductPaymentRequest;
import kodlama.io.ecommerce.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private int productId;

    private double price;
    @NotNull
    private int amount; //miktar



    @NotBlank
    private PaymentRequest paymentRequest; // kart bilgileri


}
//todo tamam