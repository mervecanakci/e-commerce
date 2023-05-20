package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CategoryService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.ecommerce.business.dto.responses.get.all.GetAllCategoriesResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.ecommerce.business.rules.CategoryBusinessRules;
import kodlama.io.ecommerce.entities.concretes.Category;
import kodlama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
private final CategoryRepository repository;
private final ModelMapper mapper;
private final CategoryBusinessRules rules;
    @Override
    @Cacheable(value = "category_list") //değişken adı vermiş gibi oldu
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.map(category,GetAllCategoriesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCategoryResponse getById(int id) {
       // rules.checkIfCategoryExistsById(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);

        return response;    }

    @Override
    @CacheEvict(value = "category_list", allEntries = true)
    public CreateCategoryResponse add(CreateCategoryRequest request) {
      //  rules.checkIfBrandExistsByName(request.getName());
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);
        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "category_list", allEntries = true)
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
      //  rules.checkIfBrandExistsById(id);
         Category category= mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);

        return response;
    }

    @Override
    @CacheEvict(value = "category_list", allEntries = true)
    public void delete(int id) {
       // rules.checkIfBrandExistsById(id);
        repository.deleteById(id);
    }
}
