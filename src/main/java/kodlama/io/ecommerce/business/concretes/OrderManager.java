package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.OrderService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateOrderRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateOrderRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllOrdersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateOrderResponse;
import kodlama.io.ecommerce.business.rules.OrderBusinessRules;
import kodlama.io.ecommerce.entities.concretes.Order;
import kodlama.io.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;
    private final OrderBusinessRules rules;

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = repository.findAll();
        List<GetAllOrdersResponse> response = orders
                .stream()
                .map(order -> mapper.map(order, GetAllOrdersResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetOrderResponse getById(int id) {
        //  rules.checkIfInvoiceExists(id);
        Order order = repository.findById(id).orElseThrow();
        GetOrderResponse response = mapper.map(order, GetOrderResponse.class);

        return response;
    }

    @Override
    public CreateOrderResponse add(CreateOrderRequest request) {
        Order order = mapper.map(request, Order.class);
        order.setId(0);
        repository.save(order);
        CreateOrderResponse response = mapper.map(order, CreateOrderResponse.class);

        return response;
    }

    @Override
    public UpdateOrderResponse update(int id, UpdateOrderRequest request) {
        //    rules.checkIfInvoiceExists(id);
        Order order = mapper.map(request, Order.class);
        order.setId(id);
        repository.save(order);
        UpdateOrderResponse response = mapper.map(order, UpdateOrderResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        //  rules.checkIfInvoiceExists(id);
        repository.deleteById(id);
    }
}
