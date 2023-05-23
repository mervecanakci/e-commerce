package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.common.constants.Messages;
import kodlama.io.ecommerce.core.exceptions.BusinessException;
import kodlama.io.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderBusinessRules {
    private final OrderRepository repository;
    public void checkIfOrderExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Order.NotFound);
        }
    }
}
