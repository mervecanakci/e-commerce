package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateOrderRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateOrderRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllOrdersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateOrderResponse;

import java.util.List;

public interface OrderService {
    List<GetAllOrdersResponse> getAll();

    GetOrderResponse getById(int id);

    CreateOrderResponse add(CreateOrderRequest request);

    UpdateOrderResponse update(int id, UpdateOrderRequest request);

    void delete(int id);
}
//todo servis kısmı tamam