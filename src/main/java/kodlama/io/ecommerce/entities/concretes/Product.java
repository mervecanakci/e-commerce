package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private State state; //stok durumu -->  IN_STOCK or OUT_OF_STOCK
    private double price;
    private double totalPrice;
    private LocalDateTime dateOfReceipt; // Fatura tarihi
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
    @ManyToMany(mappedBy = "products")
    private List<Customer> customers = new ArrayList<>();

  /*  @ManyToMany(mappedBy = "products")
    private List<Seller> sellers = new ArrayList<>();*/

  /*  @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductOrder> productOrder;
      @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductSeller> productSeller;
*/
}
//TODO: TAMAMLNADI PRODUCT