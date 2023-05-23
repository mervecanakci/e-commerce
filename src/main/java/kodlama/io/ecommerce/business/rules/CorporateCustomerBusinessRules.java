package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.CorporateCustomerRepository;
import kodlama.io.ecommerce.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {
    private final CorporateCustomerRepository repository;
    public void checkIfCorporateCustomerExistsById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.CorporateCustomer.NotExists);
        }
    }
}
