package kodlama.io.ecommerce.business.dto.responses.update;

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
public class UpdateInvoiceResponse{
    private int id;
    private int orderId;
    private int corporateCustomerId;
    private String cardHolder; // kart sahibi
    private String productName; //ürün adı
    private String corporateCustomerName; // satıcı adı
    private int productQuantity; //ürün miktarı
    private double productPrice; //ürün fiyatı
    private double totalPrice; //toplam fiyat
    private LocalDateTime dateOfReceipt;
    private InvoiceType invoiceType;
}

