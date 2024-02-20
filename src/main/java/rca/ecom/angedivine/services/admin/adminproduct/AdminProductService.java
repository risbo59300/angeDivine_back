package rca.ecom.angedivine.services.admin.adminproduct;

import rca.ecom.angedivine.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {

        public ProductDto addProduct(ProductDto productDto) throws IOException;

        public List<ProductDto> getAllProducts();

        public List<ProductDto> getAllProductByName(String name);

        public boolean deleteProduct(long id);

}
