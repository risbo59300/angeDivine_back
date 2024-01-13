package rca.ecom.angedivine.entities;

import jakarta.persistence.*;
import lombok.Data;
import rca.ecom.angedivine.enums.UserRole;

@Entity
@Data
@Table(name ="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String email;

        private String password;

        private String name;

        private UserRole role;

        @Lob
        @Column(columnDefinition = "longblob")
        private byte[] img;

}
