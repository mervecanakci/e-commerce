package kodlama.io.ecommerce.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.abstracts.ProductOrder;
import kodlama.io.ecommerce.entities.abstracts.ProductSeller;
import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity; //miktar
    @Enumerated(EnumType.STRING)
    private State state;
    private double price;
    private double totalPrice;
    private LocalDateTime dateOfReceipt; // Fatura tarihi
    private String description;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductSeller> productSeller;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductOrder> productOrder;


}
