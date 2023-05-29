package kodlama.io.ecommerce.business.dto.requests.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kodlama.io.ecommerce.entities.enums.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {
    @NotBlank
    @NotNull
    private int orderId;
    @NotBlank
    private String cardHolder; // kart sahibi
    @NotBlank
    private String corporateCustomerName; // satıcı adı
    @Size(min = 1,max = 10)
    @NotBlank
    private int productQuantity; //ürün miktarı
    @NotBlank
    private double productPrice; //ürün fiyatı
    @NotBlank
    private LocalDateTime dateOfReceipt; //fatura tarihi
    @NotBlank
    private InvoiceType invoiceType; //fatura türü -->  INDIVIDUAL or CORPORATE

}
//TODO tamam
