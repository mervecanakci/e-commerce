package kodlama.io.ecommerce.entities.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login")
public class Login { // customer ve selleri ayrı ayrı almak yerine "user" alabilir miyim?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email; // @Email, @NotBlank bunları koy ileride
    private String password;

    @JsonIgnore //JSON dönüştürmesinde yer almayacak
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id",nullable = true) //alan null alabilir
    private Customer customerLogin;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)//optional yani ilgili nesneler var olmak zorunda
    @JoinColumn(name = "seller_id",nullable = true)
    private Seller sellerLogin;
/*
fetch = FetchType.LAZY özelliği, bu ilişkileri istek üzerine yüklemek (lazy loading) için yapılandırır.
Yani, kullanıcı veya yönetici bilgisi yalnızca gerektiğinde yüklenir
ve gerektiğinde bellekten temizlenir.
 */
}
