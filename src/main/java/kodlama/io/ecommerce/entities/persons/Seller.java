package kodlama.io.ecommerce.entities.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.abstracts.ProductSeller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sellers")
public class Seller extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double point; //satıcı puanı max 5.00, min 0.00
    @JsonIgnore
    @OneToMany(mappedBy = "seller")
    List<ProductSeller> productSeller;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "sellerLogin")
    private Login sellerLogin;
}
