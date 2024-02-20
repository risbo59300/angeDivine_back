package rca.ecom.angedivine.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {

        private Long id;

        private String name;

        private Long price;

        private String description;

        private byte[] byteImg;

        private Long categoryId;

        private String categoryName;

        private MultipartFile img; // Pour reccupérer l'image venant du front
}
