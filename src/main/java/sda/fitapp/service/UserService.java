package sda.fitapp.service;

import org.springframework.stereotype.Component;
import sda.fitapp.entity.User;
import sda.fitapp.repositories.UserRepositories;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserService {

    private final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    public User getUserById(long id){
        return userRepositories.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User addUser(User user) {
        return userRepositories.save(user);
    }

    public void removeUserById(long id) {
        User userToDelete = userRepositories.findById(id).orElseThrow(NoSuchElementException::new);
        userRepositories.delete(userToDelete);
    }

}
