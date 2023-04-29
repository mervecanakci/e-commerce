package kodlama.io.ecommerce.entities.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.concretes.VerificationCode;

public class Customer extends User {
    private int id;
    private String identityNumber;
    private int birthYear;

    @ManyToOne()
    @JoinColumn(name = "verification_code_id_customers")
    private VerificationCode VerificationCodeCustomers;

    @JsonIgnore
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "customerLogin")
    private Login customerLogin;
}
