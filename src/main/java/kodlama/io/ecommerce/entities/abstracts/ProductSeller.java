package kodlama.io.ecommerce.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.entities.persons.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_seller")
public class ProductSeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
