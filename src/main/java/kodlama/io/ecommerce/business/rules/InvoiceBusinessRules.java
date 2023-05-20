package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  InvoiceBusinessRules  {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Invoice.NotFound);
        }
    }
}
