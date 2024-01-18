package rca.ecom.angedivine.services.admin.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rca.ecom.angedivine.dto.CategoryDto;
import rca.ecom.angedivine.entities.Category;
import rca.ecom.angedivine.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

        private final CategoryRepository categoryRepository;

        public Category createCategory(CategoryDto categoryDto){
                Category category = new Category();
                category.setName(category.getName());
                category.setDescription(category.getDescription());

                return categoryRepository.save(category);
        }

}
