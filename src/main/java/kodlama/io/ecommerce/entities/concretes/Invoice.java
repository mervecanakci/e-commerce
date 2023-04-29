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
    private String cardHolder;
    private String brandName;
    private String productName;
    private int productQuantity;
    private double productPrice;
    private double totalPrice;
    private LocalDateTime dateOfReceipt;
    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
