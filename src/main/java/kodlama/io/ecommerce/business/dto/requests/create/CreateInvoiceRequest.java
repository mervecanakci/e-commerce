package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kodlama.io.ecommerce.entities.enums.InvoiceType;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {



    @NotBlank
    @NotNull
    private int orderId;
    private int corporateCustomerId;

    @NotBlank
    private String cardHolder; // kart sahibi
    @NotBlank
    private String productName; //ürün adı
    @Size(min = 1,max = 10)
    @NotBlank
    private int amount; //ürün miktarı
    @NotBlank
    private double productPrice; //ürün fiyatı

    private double totalPrice;
    @NotBlank
    private LocalDateTime dateOfReceipt; //fatura tarihi
    @NotBlank
    private InvoiceType invoiceType; //fatura türü -->  INDIVIDUAL or CORPORATE



}
//TODO tamam
