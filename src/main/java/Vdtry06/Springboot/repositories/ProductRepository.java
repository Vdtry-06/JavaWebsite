package Vdtry06.Springboot.repositories;

import Vdtry06.Springboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<"kieu thuc the", "chia khoa chinh">
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
