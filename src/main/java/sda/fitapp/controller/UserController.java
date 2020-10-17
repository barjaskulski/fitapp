package sda.fitapp.controller;

import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.entity.User;
import sda.fitapp.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUserById(@PathVariable long userId) {
        userService.removeUserById(userId);
    }
}
