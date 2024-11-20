package com.example.nimapassessment.controller;


import com.example.nimapassessment.entity.Product;
import com.example.nimapassessment.services.ProductService;
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
@RequestMapping({"/api/products"})
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController() {
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        return this.productService.getAllProducts(PageRequest.of(page, 10));
    }

    @GetMapping({"/{id}"})
    public Product getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }

    @PutMapping({"/{id}"})
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return this.productService.updateProduct(id, product);
    }

    @DeleteMapping({"/{id}"})
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }
}
