package kodlama.io.ecommerce.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.abstracts.ProductOrder;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<ProductOrder> productOrder;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Invoice invoice;

    //cascade; order sınıfında bir değişiklik yapıldığında bu
    // değişikliğin invoice sınıfındaki ilgili alanlara da yansıtılmasını sağlar.
}
