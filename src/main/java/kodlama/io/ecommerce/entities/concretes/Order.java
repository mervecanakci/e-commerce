package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Invoice invoice;
    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "individualCustomerId")
    private IndividualCustomer individualCustomer;
    /*
      @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<ProductOrder> productOrder;
     */

    //cascade; order sınıfında bir değişiklik yapıldığında bu
    // değişikliğin invoice sınıfındaki ilgili alanlara da yansıtılmasını sağlar.
}
//TODO: TAMAMLNADI ORDER