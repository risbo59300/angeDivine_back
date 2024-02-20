package rca.ecom.angedivine.services.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rca.ecom.angedivine.dto.ProductDto;
import rca.ecom.angedivine.entities.Product;
import rca.ecom.angedivine.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService{

        private final ProductRepository productRepository;

        public List<ProductDto> getAllProducts() {
                List<Product> products = productRepository.findAll();
                return products.stream().map(Product::getDto).collect(
                                Collectors.toList());
        }

        public List<ProductDto> searchProductByTitle(String name) {
                List<Product> products = productRepository.findAllByNameContaining(name);
                return products.stream().map(Product::getDto).collect(
                                Collectors.toList());
        }
}
