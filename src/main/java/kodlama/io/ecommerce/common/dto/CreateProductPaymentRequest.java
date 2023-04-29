package kodlama.io.ecommerce.common.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductPaymentRequest {
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String cardCvv;
    private double price;
}
