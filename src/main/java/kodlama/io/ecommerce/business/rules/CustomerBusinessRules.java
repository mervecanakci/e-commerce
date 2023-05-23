package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.CustomerRepository;
import kodlama.io.ecommerce.repository.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository repository;
    public void checkIfCustomerExistsById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Customer.NotExists);
        }
    }
}
