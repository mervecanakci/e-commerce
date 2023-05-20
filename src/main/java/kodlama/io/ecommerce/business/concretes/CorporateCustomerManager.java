package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CorporateCustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCorporateCustomerResponse;
import kodlama.io.ecommerce.business.rules.CorporateCustomerBusinessRules;
import kodlama.io.ecommerce.entities.concretes.CorporateCustomer;
import kodlama.io.ecommerce.repository.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository repository;
    private final ModelMapper mapper;
    private final CorporateCustomerBusinessRules rules;
    @Override
    @Cacheable(value = "corporateCustomer_list") //değişken adı vermiş gibi oldu
    public List<GetAllCorporateCustomerResponse> getAll() {
            List<CorporateCustomer> corporateCustomers = repository.findAll();
        List<GetAllCorporateCustomerResponse> response = corporateCustomers
                .stream()
                .map(corporateCustomer -> mapper.map(corporateCustomer,GetAllCorporateCustomerResponse.class))
                .toList();
        return response;
    }
    
    @Override
    public GetCorporateCustomerResponse getById(int id) {
        // rules.checkIfCorporateCustomerExistsById(id);
        CorporateCustomer corporateCustomer = repository.findById(id).orElseThrow();
        GetCorporateCustomerResponse response = mapper.map(corporateCustomer, GetCorporateCustomerResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "corporateCustomer_list", allEntries = true)
    public CreateCorporateCustomerResponse add(CreateCorporateCustomerRequest request) {
        //  rules.checkIfBrandExistsByName(request.getName());
        CorporateCustomer corporateCustomer = mapper.map(request, CorporateCustomer.class);
        corporateCustomer.setId(0);
        repository.save(corporateCustomer);
        CreateCorporateCustomerResponse response = mapper.map(corporateCustomer, CreateCorporateCustomerResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "corporateCustomer_list", allEntries = true)
    public UpdateCorporateCustomerResponse update(int id, UpdateCorporateCustomerRequest request) {
        //  rules.checkIfBrandExistsById(id);
        CorporateCustomer corporateCustomer= mapper.map(request, CorporateCustomer.class);
        corporateCustomer.setId(id);
        repository.save(corporateCustomer);
        UpdateCorporateCustomerResponse response = mapper.map(corporateCustomer, UpdateCorporateCustomerResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "corporateCustomer_list", allEntries = true)
    public void delete(int id) {
        // rules.checkIfBrandExistsById(id);
        repository.deleteById(id);
    }

}
