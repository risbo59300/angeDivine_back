package rca.ecom.angedivine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rca.ecom.angedivine.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}