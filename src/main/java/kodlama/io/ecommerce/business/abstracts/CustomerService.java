package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();

    GetCustomersResponse getById(int id);

    CreateCustomersResponse add(CreateCustomerRequest request);

    UpdateCustomersResponse update(int id, UpdateCustomerRequest request);

    void delete(int id);
}
