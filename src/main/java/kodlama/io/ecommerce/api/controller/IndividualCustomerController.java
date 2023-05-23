package kodlama.io.ecommerce.api.controller;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.business.abstracts.IndividualCustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateIndividualCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetIndividualCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllIndividualCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateIndividualCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/individual-customers")
public class IndividualCustomerController {
    private final IndividualCustomerService service;

    @GetMapping
    public List<GetAllIndividualCustomersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetIndividualCustomerResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateIndividualCustomerResponse update(@PathVariable int id, @Valid @RequestBody UpdateIndividualCustomerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
