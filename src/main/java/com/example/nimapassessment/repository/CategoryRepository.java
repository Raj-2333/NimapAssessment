package com.example.nimapassessment.repository;

import com.example.nimapassessment.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
