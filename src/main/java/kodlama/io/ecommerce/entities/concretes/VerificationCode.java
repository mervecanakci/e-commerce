package kodlama.io.ecommerce.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.persons.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_code")
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private boolean isVerified;
    private Date verifiedDate;
    @OneToMany(mappedBy = "VerificationCodeCustomers")
    private List<Customer> customers;
}
