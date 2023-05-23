package kodlama.io.ecommerce.api.controller;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.business.abstracts.CustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomersController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomersResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateCustomersResponse add(@Valid @RequestBody CreateCustomerRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCustomersResponse update(@PathVariable int id, @Valid @RequestBody UpdateCustomerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
