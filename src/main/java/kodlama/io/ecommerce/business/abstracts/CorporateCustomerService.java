package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCorporateCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {
    List<GetAllCorporateCustomersResponse> getAll();

    GetCorporateCustomerResponse getById(int id);

    CreateCorporateCustomerResponse add(CreateCorporateCustomerRequest request);

    UpdateCorporateCustomerResponse update(int id, UpdateCorporateCustomerRequest request);

    void delete(int id);
}
//todo servis kısmı tamam