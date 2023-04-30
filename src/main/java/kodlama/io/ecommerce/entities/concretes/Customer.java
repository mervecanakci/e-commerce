package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.ecommerce.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateRegistered;
   /* @OneToMany(mappedBy = "customer")
    List<Product> products;*/
    //TODO: product foreignkey

    @OneToMany(mappedBy = "customer")
    List<Payment> payment;
    @ManyToMany
    @JoinTable(
            name = "product_customer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

}
//TODO: TAMAMLNADI customer