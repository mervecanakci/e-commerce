package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
