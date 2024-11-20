package com.example.nimapassessment.repository;

import com.example.nimapassessment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
