package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sellers")
public class CorporateCustomer extends Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String taxNumber;
    private double point; //satıcı puanı max 5.00, min 0.00
/*
    @ManyToMany
    @JoinTable(
            name = "product_seller",
            joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

*/

    /*
       @JsonIgnore
    @OneToMany(mappedBy = "seller")
    List<ProductSeller> productSeller;
     */
}
