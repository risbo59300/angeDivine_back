package rca.ecom.angedivine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ecom.angedivine.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}