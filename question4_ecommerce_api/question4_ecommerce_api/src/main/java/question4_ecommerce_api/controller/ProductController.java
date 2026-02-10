package question4_ecommerce_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // In-memory product list
    private List<Product> products = new ArrayList<>();

    // Constructor - Initialize with 10 sample products
    public ProductController() {
        products.add(new Product(1L, "iPhone 15 Pro", "Latest Apple smartphone with A17 chip", 999.99, "Electronics", 50, "Apple"));
        products.add(new Product(2L, "Samsung Galaxy S24", "Flagship Android smartphone", 899.99, "Electronics", 30, "Samsung"));
        products.add(new Product(3L, "MacBook Pro", "Powerful laptop for professionals", 2499.99, "Computers", 20, "Apple"));
        products.add(new Product(4L, "Dell XPS 15", "High-performance laptop", 1799.99, "Computers", 15, "Dell"));
        products.add(new Product(5L, "Sony WH-1000XM5", "Noise-cancelling headphones", 399.99, "Audio", 100, "Sony"));
        products.add(new Product(6L, "AirPods Pro", "Premium wireless earbuds", 249.99, "Audio", 200, "Apple"));
        products.add(new Product(7L, "Nike Air Max", "Comfortable running shoes", 129.99, "Footwear", 0, "Nike"));
        products.add(new Product(8L, "Adidas Ultraboost", "Performance running shoes", 149.99, "Footwear", 75, "Adidas"));
        products.add(new Product(9L, "Kindle Paperwhite", "E-reader with backlight", 139.99, "Electronics", 60, "Amazon"));
        products.add(new Product(10L, "Logitech MX Master 3", "Ergonomic wireless mouse", 99.99, "Accessories", 120, "Logitech"));
    }

    // GET /api/products - Get all products with optional pagination
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit) {
        
        if (page != null && limit != null) {
            int start = page * limit;
            int end = Math.min(start + limit, products.size());
            
            if (start >= products.size()) {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
            }
            
            List<Product> paginatedProducts = products.subList(start, end);
            return new ResponseEntity<>(paginatedProducts, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // GET /api/products/{productId} - Get product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET /api/products/category/{category} - Get products by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/products/brand/{brand} - Get products by brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/products/search?keyword={keyword} - Search by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(lowerKeyword) ||
                product.getDescription().toLowerCase().contains(lowerKeyword)) {
                result.add(product);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/products/price-range?min={min}&max={max} - Get products by price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/products/in-stock - Get products with stock > 0
    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getInStockProducts() {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                result.add(product);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // POST /api/products - Add new product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // PUT /api/products/{productId} - Update product
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductId().equals(productId)) {
                updatedProduct.setProductId(productId);
                products.set(i, updatedProduct);
                return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PATCH /api/products/{productId}/stock?quantity={quantity} - Update stock
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {
        
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/products/{productId} - Delete product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}