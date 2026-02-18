package auca.ac.rw.restfullApiAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product p1 = new Product();
            p1.setName("Laptop");
            p1.setDescription("Gaming laptop");
            p1.setPrice(1200.00);
            p1.setCategory("Electronics");
            p1.setStockQuantity(10);
            p1.setBrand("Dell");
            productRepository.save(p1);

            Product p2 = new Product();
            p2.setName("Mouse");
            p2.setDescription("Wireless mouse");
            p2.setPrice(25.00);
            p2.setCategory("Accessories");
            p2.setStockQuantity(50);
            p2.setBrand("Logitech");
            productRepository.save(p2);
        }
    }
}
