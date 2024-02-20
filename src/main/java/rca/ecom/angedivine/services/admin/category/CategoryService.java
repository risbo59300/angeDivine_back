package rca.ecom.angedivine.services.admin.category;

import rca.ecom.angedivine.dto.CategoryDto;
import rca.ecom.angedivine.entities.Category;

import java.util.List;

public interface CategoryService {

        public Category createCategory(CategoryDto categoryDto);

        public List<Category> getAllCategories();
}
