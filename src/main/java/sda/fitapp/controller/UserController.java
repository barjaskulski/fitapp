package sda.fitapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.dto.QuestionnaireDto;
import sda.fitapp.entity.UserEntity;
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
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserEntity getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUserById(@PathVariable long userId) {
        userService.removeUserById(userId);
    }

    @GetMapping("/users/current_user")               //----------------------------- for front end dev
    public UserEntity getCurrentUser() {
        return new UserEntity(1,"email@pl","password",
                "firstN", "lastN", true);
    }

    @PostMapping("/questionnaire")                  //----------------------------- for front end dev
    public void addQuestionnaire(@RequestBody QuestionnaireDto questionnaire) {
        log.info("questionnaire: {}", questionnaire.getAge());
    }
}
