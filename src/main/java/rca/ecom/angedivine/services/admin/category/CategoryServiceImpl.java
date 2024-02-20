package rca.ecom.angedivine.services.admin.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rca.ecom.angedivine.dto.CategoryDto;
import rca.ecom.angedivine.entities.Category;
import rca.ecom.angedivine.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

        private final CategoryRepository categoryRepository;

        public Category createCategory(CategoryDto categoryDto){
                Category category = new Category();
                category.setName(categoryDto.getName());
                category.setDescription(categoryDto.getDescription());

                return categoryRepository.save(category);
        }

        public List<Category> getAllCategories() {
                return categoryRepository.findAll();
        }

}
