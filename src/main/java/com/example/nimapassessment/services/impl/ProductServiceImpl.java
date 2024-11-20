package com.example.nimapassessment.services.impl;


import com.example.nimapassessment.entity.Product;
import com.example.nimapassessment.repository.ProductRepository;
import com.example.nimapassessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return (Product)this.productRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Product not found with ID: " + id);
        });
    }

    public Product createProduct(Product product) {
        return (Product)this.productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = this.getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        return (Product)this.productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
