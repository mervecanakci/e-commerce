package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.IndividualCustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllIndividualCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateIndividualCustomersResponse;
import kodlama.io.ecommerce.business.rules.IndividualCustomerBusinessRules;
import kodlama.io.ecommerce.entities.concretes.IndividualCustomer;
import kodlama.io.ecommerce.repository.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService { // customer ve selleri ayrı ayrı almak yerine "user" alabilir miyim?
    private final IndividualCustomerRepository repository;
    private final ModelMapper mapper;
    private final IndividualCustomerBusinessRules rules;
    @Override
    @Cacheable(value = "individualCustomer_list") //değişken adı vermiş gibi oldu
    public List<GetAllIndividualCustomersResponse> getAll() {
        List<IndividualCustomer> individualCustomers = repository.findAll();
        List<GetAllIndividualCustomersResponse> response = individualCustomers
                .stream()
                .map(individualCustomer -> mapper.map(individualCustomer,GetAllIndividualCustomersResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetIndividualCustomerResponse getById(int id) {
        // rules.checkIfIndividualCustomerExistsById(id);
        IndividualCustomer individualCustomer = repository.findById(id).orElseThrow();
        GetIndividualCustomerResponse response = mapper.map(individualCustomer, GetIndividualCustomerResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "individualCustomer_list", allEntries = true)
    public CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        //  rules.checkIfBrandExistsByName(request.getName());
        IndividualCustomer individualCustomer = mapper.map(request, IndividualCustomer.class);
        individualCustomer.setId(0);
        repository.save(individualCustomer);
        CreateIndividualCustomerResponse response = mapper.map(individualCustomer, CreateIndividualCustomerResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "individualCustomer_list", allEntries = true)
    public UpdateIndividualCustomersResponse update(int id, UpdateIndividualCustomerRequest request) {
        //  rules.checkIfBrandExistsById(id);
        IndividualCustomer individualCustomer= mapper.map(request, IndividualCustomer.class);
        individualCustomer.setId(id);
        repository.save(individualCustomer);
        UpdateIndividualCustomersResponse response = mapper.map(individualCustomer, UpdateIndividualCustomersResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "individualCustomer_list", allEntries = true)
    public void delete(int id) {
        // rules.checkIfBrandExistsById(id);
        repository.deleteById(id);
    }
}
