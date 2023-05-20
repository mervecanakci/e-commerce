package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.PaymentService;
import kodlama.io.ecommerce.business.abstracts.PosService;
import kodlama.io.ecommerce.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdatePaymentRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreatePaymentResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetPaymentResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllPaymentsResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdatePaymentResponse;
import kodlama.io.ecommerce.business.rules.PaymentBusinessRules;
import kodlama.io.ecommerce.common.dto.CreateProductPaymentRequest;
import kodlama.io.ecommerce.entities.concretes.Payment;
import kodlama.io.ecommerce.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PosService posService;
    private final PaymentBusinessRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentsResponse> response = payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetPaymentResponse getById(int id) {
       // rules.checkIfPaymentExists(id);
        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapper.map(payment, GetPaymentResponse.class);

        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
      //  rules.checkIfCardExists(request);
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        //rules.checkIfPaymentExists(id);
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
      //  rules.checkIfPaymentExists(id);
        repository.deleteById(id);
    }
//todo burası alt aynı
    @Override
    public void processProductPayment(CreateProductPaymentRequest request) {

    }

 /*   @Override
    public void processRentalPayment(CreateProductPaymentRequest request) {
        rules.checkIfPaymentIsValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rules.checkIfBalanceIsEnough(request.getPrice(), payment.getBalance());
        posService.pay(); // fake pos service
        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);
    }*/
}//todo son kısmı yaz rules de
