package co.masterbridge.website.service;

import co.masterbridge.website.model.User;
import co.masterbridge.website.model.UserLogin;
import co.masterbridge.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getUserById(String id) {
        return userRepository.getById(id);
    }

    public User createUser(User user) {
        userRepository.create(user);
        return user;
    }

    public void updateUser(String id, User user) {
        userRepository.update(id, user); }

    public boolean login(UserLogin userLogin) {
        boolean isValid = false;
        if (userRepository.login(userLogin) != null) {
            isValid = true;
        }
        return isValid;
    }
}
