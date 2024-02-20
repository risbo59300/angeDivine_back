package rca.ecom.angedivine.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.ecom.angedivine.dto.ProductDto;
import rca.ecom.angedivine.services.admin.adminproduct.AdminProductService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AdminProductController {

        private final AdminProductService adminProductService;

        @PostMapping("/product")
        public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
                ProductDto productDto1 = adminProductService.addProduct(productDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
        }

        @GetMapping("/products")
        public ResponseEntity<List<ProductDto>> getAllProducts() {
                List<ProductDto> productDtos = adminProductService.getAllProducts();
                return ResponseEntity.ok(productDtos);
        }

        @GetMapping("/search/{name}")
        public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name) {
                List<ProductDto> productDtos = adminProductService.getAllProductByName(name);
                return ResponseEntity.ok(productDtos);
        }

        @DeleteMapping("/product/{productId}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
             boolean deleted = adminProductService.deleteProduct(productId);
             if( deleted ){
                     return ResponseEntity.noContent().build();
             }
             return ResponseEntity.notFound().build();
        }

}