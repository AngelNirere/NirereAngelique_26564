package bonus_userapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bonus_userapi.model.ApiResponse;
import bonus_userapi.model.UserProfile;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    
    private List<UserProfile> users = new ArrayList<>();
    
    public UserProfileController() {
        users.add(new UserProfile(1L, "john_doe", "john@example.com", "John Doe", 25, "USA", "Software Engineer", true));
        users.add(new UserProfile(2L, "jane_smith", "jane@example.com", "Jane Smith", 30, "Canada", "Data Scientist", true));
        users.add(new UserProfile(3L, "bob_johnson", "bob@example.com", "Bob Johnson", 22, "UK", "Student", false));
        users.add(new UserProfile(4L, "alice_wong", "alice@example.com", "Alice Wong", 28, "Australia", "UX Designer", true));
        users.add(new UserProfile(5L, "mike_brown", "mike@example.com", "Mike Brown", 35, "USA", "Project Manager", true));
        users.add(new UserProfile(6L, "sarah_lee", "sarah@example.com", "Sarah Lee", 26, "South Korea", "Web Developer", false));
        users.add(new UserProfile(7L, "david_chen", "david@example.com", "David Chen", 32, "China", "Mobile Developer", true));
        users.add(new UserProfile(8L, "emma_wilson", "emma@example.com", "Emma Wilson", 29, "Canada", "DevOps Engineer", true));
    }
    
    @GetMapping
    public ApiResponse<List<UserProfile>> getAllUsers() {
        return ApiResponse.success("Users retrieved successfully", users);
    }
    
    @GetMapping("/{userId}")
    public ApiResponse<UserProfile> getUserById(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                return ApiResponse.success("User found", user);
            }
        }
        return ApiResponse.error("User not found with ID: " + userId);
    }
    
    @GetMapping("/search")
    public ApiResponse<List<UserProfile>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                result.add(user);
            }
        }
        if (result.isEmpty()) {
            return ApiResponse.error("No users found with username containing: " + username);
        }
        return ApiResponse.success("Users found", result);
    }
    
    @GetMapping("/country/{country}")
    public ApiResponse<List<UserProfile>> getUsersByCountry(@PathVariable String country) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }
        if (result.isEmpty()) {
            return ApiResponse.error("No users found from country: " + country);
        }
        return ApiResponse.success("Users from " + country + " found", result);
    }
    
    @PostMapping
    public ApiResponse<UserProfile> createUser(@RequestBody UserProfile user) {
        for (UserProfile existing : users) {
            if (existing.getUsername().equalsIgnoreCase(user.getUsername())) {
                return ApiResponse.error("Username already exists: " + user.getUsername());
            }
        }
        users.add(user);
        return ApiResponse.success("User created successfully", user);
    }
    
    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                users.remove(user);
                return ApiResponse.success("User deleted successfully");
            }
        }
        return ApiResponse.error("User not found with ID: " + userId);
    }
}