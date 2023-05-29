package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardHolder; // kart sahibi
    private String productName; //ürün adı

    private int productQuantity; //ürün miktarı
    private double productPrice; //ürün fiyatı
    private double totalPrice; //toplam fiyat
    private LocalDateTime dateOfReceipt; //fatura tarihi
    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType; //fatura türü -->  INDIVIDUAL or CORPORATE

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
//TODO: TAMAMLNADI INVOICE