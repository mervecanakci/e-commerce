package kodlama.io.ecommerce.common.dto;

import kodlama.io.ecommerce.business.dto.requests.PaymentRequest;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductPaymentRequest extends PaymentRequest {
    private double price;
}
