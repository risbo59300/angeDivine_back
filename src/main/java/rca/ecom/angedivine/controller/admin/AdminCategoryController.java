package rca.ecom.angedivine.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rca.ecom.angedivine.dto.CategoryDto;
import rca.ecom.angedivine.entities.Category;
import rca.ecom.angedivine.services.admin.category.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AdminCategoryController {

        private final CategoryService categoryService;

        @PostMapping("/category")
        public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
                Category category = categoryService.createCategory(categoryDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }

        @GetMapping("")
        public ResponseEntity<List<Category>> getAllCategories() {
                return ResponseEntity.ok(categoryService.getAllCategories());
        }

}
