package auca.ac.rw.restfullApiAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;


    public String addNewProduct(Product product) {
        try {
            // Check if product with same name already exists
            if (product.getName() != null && productRepository.existsByName(product.getName())) {
                return "Product with name '" + product.getName() + "' already exists";
            }
            productRepository.save(product);
            return "Product added successfully";
        } catch (Exception e) {
            return "Error adding product: " + e.getMessage();
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public String updateProduct(Long id, Product product) {
        Optional<Product> existProduct = productRepository.findById(id);
        if(existProduct.isPresent()) {
            Product existing = existProduct.get();
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            existing.setStockQuantity(product.getStockQuantity());
            existing.setBrand(product.getBrand());
            productRepository.save(existing);
            return "Product updated successfully";
        }
        return "Product not found";
    }

    public String deleteProduct(Long id) {
        Optional<Product> existProduct = productRepository.findById(id);
        if(existProduct.isPresent()) {
            productRepository.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }
}
