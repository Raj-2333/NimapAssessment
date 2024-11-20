package com.example.nimapassessment.controller;


import com.example.nimapassessment.entity.Category;
import com.example.nimapassessment.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/categories"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController() {
    }

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        return this.categoryService.getAllCategories(PageRequest.of(page, 10));
    }

    @GetMapping({"/{id}"})
    public Category getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return this.categoryService.createCategory(category);
    }

    @PutMapping({"/{id}"})
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return this.categoryService.updateCategory(id, category);
    }

    @DeleteMapping({"/{id}"})
    public void deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
    }
}

