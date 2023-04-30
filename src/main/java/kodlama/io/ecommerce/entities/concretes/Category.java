package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    //Set koleksiyonu, her bir öğenin eşsiz olmasını sağlar ve bunu
    //sağlamak istediğiniz durumlarda kullanmak daha uygun olabilir.
}
//TODO: TAMAMLNADI CATEGORY