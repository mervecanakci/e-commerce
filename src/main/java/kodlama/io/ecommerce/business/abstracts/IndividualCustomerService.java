package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllIndividualCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    List<GetAllIndividualCustomersResponse> getAll();

    GetIndividualCustomerResponse getById(int id);

    CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest request);

    UpdateIndividualCustomerResponse update(int id, UpdateIndividualCustomerRequest request);

    void delete(int id);
}
//todo servis kısmı tamam