package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateUserRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateUserRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateUserResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetUserResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllUsersResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateUserResponse;

import java.util.List;

public interface UserService {

    List<GetAllUsersResponse> getAll();

    GetUserResponse getById(int id);

    CreateUserResponse add(CreateUserRequest request);

    UpdateUserResponse update(int id, UpdateUserRequest request);

    void delete(int id);
}
//todo servis kısmı tamam