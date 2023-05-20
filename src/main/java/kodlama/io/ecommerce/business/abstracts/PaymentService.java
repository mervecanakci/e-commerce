package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdatePaymentRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreatePaymentResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetPaymentResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllPaymentsResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdatePaymentResponse;
import kodlama.io.ecommerce.common.dto.CreateProductPaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(int id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);

    void delete(int id);

    void processProductPayment(CreateProductPaymentRequest request);
}
