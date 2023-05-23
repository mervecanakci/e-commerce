package kodlama.io.ecommerce.api.controller;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.business.abstracts.OrderService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateOrderRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateOrderRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllOrdersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;

    @GetMapping
    public List<GetAllOrdersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetOrderResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse add(@Valid @RequestBody CreateOrderRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateOrderResponse update(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
