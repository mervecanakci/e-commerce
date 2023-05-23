package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCustomersResponse;
import kodlama.io.ecommerce.business.rules.CustomerBusinessRules;
import kodlama.io.ecommerce.entities.concretes.Customer;
import kodlama.io.ecommerce.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerBusinessRules rules;
    @Override
    @Cacheable(value = "customer_list") //değişken adı vermiş gibi oldu
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer -> mapper.map(customer,GetAllCustomersResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCustomersResponse getById(int id) {
         rules.checkIfCustomerExistsById(id);
        Customer customer = repository.findById(id).orElseThrow();
        GetCustomersResponse response = mapper.map(customer, GetCustomersResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "customer_list", allEntries = true)
    public CreateCustomersResponse add(CreateCustomerRequest request) {
        //rules.checkIfCustomerExistsByName(request.getName());
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        repository.save(customer);
        CreateCustomersResponse response = mapper.map(customer, CreateCustomersResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "customer_list", allEntries = true)
    public UpdateCustomersResponse update(int id, UpdateCustomerRequest request) {
        rules.checkIfCustomerExistsById(id);
        Customer customer= mapper.map(request,Customer.class);
        customer.setId(id);
        repository.save(customer);
        UpdateCustomersResponse response = mapper.map(customer, UpdateCustomersResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "customer_list", allEntries = true)
    public void delete(int id) {
        rules.checkIfCustomerExistsById(id);
        repository.deleteById(id);
    }

}
