package question3_restauntntapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import question3_restauntntapi.MenuItem;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    // Sample menu items list (in-memory storage)
    private List<MenuItem> menuItems = new ArrayList<>();

    // Constructor - Initialize with 8 sample menu items
    public MenuController() {
        // Appetizers
        menuItems.add(new MenuItem(1L, "Spring Rolls", "Crispy vegetable spring rolls", 8.99, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Garlic Bread", "Toasted bread with garlic butter", 6.50, "Appetizer", true));
        
        // Main Courses
        menuItems.add(new MenuItem(3L, "Grilled Salmon", "Fresh salmon with lemon sauce", 22.99, "Main Course", true));
        menuItems.add(new MenuItem(4L, "Beef Steak", "Premium beef steak with vegetables", 28.50, "Main Course", true));
        menuItems.add(new MenuItem(5L, "Vegetarian Pasta", "Pasta with fresh vegetables", 15.99, "Main Course", false));
        
        // Desserts
        menuItems.add(new MenuItem(6L, "Chocolate Cake", "Rich chocolate layer cake", 7.99, "Dessert", true));
        menuItems.add(new MenuItem(7L, "Ice Cream", "Vanilla ice cream with toppings", 5.50, "Dessert", true));
        
        // Beverages
        menuItems.add(new MenuItem(8L, "Fresh Orange Juice", "Freshly squeezed orange juice", 4.99, "Beverage", true));
    }

    // GET /api/menu - Get all menu items
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    // GET /api/menu/{id} - Get specific menu item
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    //