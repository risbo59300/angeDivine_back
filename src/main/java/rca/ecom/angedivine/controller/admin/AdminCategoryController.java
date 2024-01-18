package rca.ecom.angedivine.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rca.ecom.angedivine.dto.CategoryDto;
import rca.ecom.angedivine.entities.Category;
import rca.ecom.angedivine.services.admin.category.CategoryService;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

        private final CategoryService categoryService;

        @PostMapping("/category")
        public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
                Category category = categoryService.createCategory(categoryDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }

}
