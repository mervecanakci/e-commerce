package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository repository;
    public void checkIfIndividualCustomerExistsById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.IndividualCustomer.NotExists);
        }
    }
}
