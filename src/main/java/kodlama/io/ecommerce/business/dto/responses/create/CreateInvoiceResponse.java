package kodlama.io.ecommerce.business.dto.responses.create;

import kodlama.io.ecommerce.entities.concretes.Product;
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
public class CreateInvoiceResponse {
    private int id;
    private int orderId;
    private int corporateCustomerId;
    private String cardHolder; // kart sahibi
    private Product product; //ürün adı
    private String corporateCustomerName; // satıcı adı
    private int productQuantity; //ürün miktarı
    private double productPrice; //ürün fiyatı
    private double totalPrice; //toplam fiyat
    private LocalDateTime dateOfReceipt;
    private InvoiceType invoiceType;

}


