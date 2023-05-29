package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.*;
import kodlama.io.ecommerce.business.dto.requests.create.CreateInvoiceRequest;
import kodlama.io.ecommerce.business.dto.requests.create.CreateOrderRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateOrderRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetOrderResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetUserResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllOrdersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateOrderResponse;
import kodlama.io.ecommerce.business.rules.OrderBusinessRules;
import kodlama.io.ecommerce.common.dto.CreateProductPaymentRequest;
import kodlama.io.ecommerce.entities.concretes.Order;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;
    private final OrderBusinessRules rules;

    private final UserService userService;

    private final PaymentService paymentService;
    private final ProductService productService;

    private final InvoiceService invoiceService;

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
        rules.checkIfOrderExists(id);
        Order order = repository.findById(id).orElseThrow();
        GetOrderResponse response = mapper.map(order, GetOrderResponse.class);

        return response;
    }

    @Override
    public CreateOrderResponse add(CreateOrderRequest request) {

        GetProductResponse getProductResponse = productService.getById(request.getProductId());

        Order order = mapper.map(request, Order.class);
        order.setId(0);
        order.setTotalPrice(getTotalPrice(order));
        order.setProductName(getProductResponse.getName());
        //create payment

        CreateProductPaymentRequest paymentRequest = new CreateProductPaymentRequest();
        mapper.map(request.getPaymentRequest(), paymentRequest);
        paymentRequest.setPrice(getTotalPrice(order));
         mapper.map(paymentRequest,request.getPaymentRequest());
        paymentService.processProductPayment(paymentRequest);


        CreateInvoiceRequest invoiceRequest = new CreateInvoiceRequest();
        invoiceRequest.setDateOfReceipt(LocalDateTime.now());
        invoiceRequest.setTotalPrice(getTotalPrice(order));
        createInvoiceRequest(request, invoiceRequest);

        invoiceService.add(invoiceRequest);
        repository.save(order);
        CreateOrderResponse response = mapper.map(order, CreateOrderResponse.class);

        // Create Invoice



        return response;
    }

    @Override
    public UpdateOrderResponse update(int id, UpdateOrderRequest request) {
        rules.checkIfOrderExists(id);
        Order order = mapper.map(request, Order.class);
        order.setId(id);
        repository.save(order);
        UpdateOrderResponse response = mapper.map(order, UpdateOrderResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfOrderExists(id);
        repository.deleteById(id);
    }
    private double getTotalPrice(Order order) {
        return order.getPrice()* order.getAmount();
    }
    private void createInvoiceRequest(CreateOrderRequest request, CreateInvoiceRequest invoiceRequest) {
        GetProductResponse product = productService.getById(request.getProductId());

        invoiceRequest.setCardHolder(request.getPaymentRequest().getCardHolder());
        invoiceRequest.setProductName(product.getName());
        invoiceRequest.setProductPrice(product.getPrice());
        invoiceRequest.setAmount(product.getQuantity());
        invoiceRequest.setDateOfReceipt(LocalDateTime.now());


    }
}
