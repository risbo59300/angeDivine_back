package rca.ecom.angedivine.services.customer;

import rca.ecom.angedivine.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

        public List<ProductDto> getAllProducts() ;

        public List<ProductDto> searchProductByTitle(String name) ;

}
