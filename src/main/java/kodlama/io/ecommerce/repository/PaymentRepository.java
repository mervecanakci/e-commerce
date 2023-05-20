package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // uniq olsun istediğimiz için:
    //bu sorguyu rental da kullanıcaz caRDnUMBER UNİQ DİYE ONLA YAPTIK
    Payment findByCardNumber(String cardNumber);

    boolean existsByCardNumber(String cardNumber);

    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
            String cardNumber, String cardHolder, int cardExpirationYear, int cardExpirationMonth, String cardCvv
    );
}
