package kodlama.io.ecommerce.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest { // base super class

    @Length(min = 16, max = 16, message = "Kart numarası 16 haneden oluşmalıdır.")
    private String cardNumber; // 16 haneli


    @Length(min = 5, message = "Kart sahibi bilgisi en az 5 karakterden oluşmalıdır.")
    private String cardHolder;

    @Min(value = 2023, message = "Kart son kullanma yılı geçersiz.")
    private int cardExpirationYear; // minimum 2023

    @Max(value = 12)
    @Min(value = 1)
    private int cardExpirationMonth; // 1 ile 12


    @Length(min = 3, max = 3)
    private String cardCvv; // 3 haneli olmalı
}
//todo tamam