package rca.ecom.angedivine.services.admin.adminproduct;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rca.ecom.angedivine.dto.ProductDto;
import rca.ecom.angedivine.entities.Category;
import rca.ecom.angedivine.entities.Product;
import rca.ecom.angedivine.repository.CategoryRepository;
import rca.ecom.angedivine.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService{

        private final ProductRepository productRepository;
        private final CategoryRepository categoryRepository;


        public ProductDto addProduct(ProductDto productDto) throws IOException {
                Product product = new Product();
                product.setName(productDto.getName());
                product.setDescription(productDto.getDescription());
                product.setPrice(productDto.getPrice());
                product.setImg(productDto.getImg().getBytes());

                Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

                product.setCategory(category);
                return productRepository.save(product).getDto();
        }

        public List<ProductDto> getAllProducts() {
                List<Product> products = productRepository.findAll();
                return products.stream().map(Product::getDto).collect(
                                Collectors.toList());
        }

        public List<ProductDto> getAllProductByName(String name) {
                List<Product> products = productRepository.findAllByNameContaining(name);
                return products.stream().map(Product::getDto).collect(
                                Collectors.toList());
        }

        public boolean deleteProduct(long id){
                Optional<Product> optionalProduct = productRepository.findById(id);
                if( optionalProduct.isPresent()){
                        productRepository.deleteById(id);
                        return true;
                }
                return false;
        }


}
