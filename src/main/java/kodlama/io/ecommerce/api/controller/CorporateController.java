package kodlama.io.ecommerce.api.controller;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.business.abstracts.CorporateCustomerService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCorporateCustomerRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCorporateCustomerResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCorporateCustomersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCorporateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/corporate-customers")
public class CorporateController {
    private final CorporateCustomerService service;

    @GetMapping
    public List<GetAllCorporateCustomersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCorporateCustomerResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateCorporateCustomerResponse add(@Valid @RequestBody CreateCorporateCustomerRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCorporateCustomerResponse update(@PathVariable int id, @Valid @RequestBody UpdateCorporateCustomerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
