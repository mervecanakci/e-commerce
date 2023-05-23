package kodlama.io.ecommerce.adapters;

import kodlama.io.ecommerce.business.abstracts.PosService;
import kodlama.io.ecommerce.common.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccessful = new Random().nextBoolean();
        if (!isPaymentSuccessful) throw new RuntimeException(Messages.Payment.Failed);
    }
}
