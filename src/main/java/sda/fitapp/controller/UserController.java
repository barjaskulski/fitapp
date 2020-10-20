package sda.fitapp.controller;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.dto.QuestionnaireDto;
import sda.fitapp.dto.UserResponse;
import sda.fitapp.entity.LifeStyle;
import sda.fitapp.entity.ServiceRoles;
import sda.fitapp.entity.User;
import sda.fitapp.entity.UserSex;
import sda.fitapp.service.UserService;

import java.util.List;

@Slf4j
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

    @GetMapping("/users/current_user")               //----------------------------- for front end dev
    public User getCurrentUser() {
        return new User(1,"email@pl","password",
                "firstN", "lastN", true);
    }

    @PostMapping("/questionnaire")                  //----------------------------- for front end dev
    public void addQuestionnaire(@RequestBody QuestionnaireDto questionnaire) {
        log.info("questionnaire: {}", questionnaire.getAge());
    }
}
