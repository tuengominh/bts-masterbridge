package co.masterbridge.website.controller;

import co.masterbridge.website.exception.NotFoundException;
import co.masterbridge.website.exception.UnauthorizedException;
import co.masterbridge.website.model.User;
import co.masterbridge.website.model.UserLogin;
import co.masterbridge.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/api/users")
public class UserApiController {

    private UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = GET)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = GET, path = "/{id}")
    public User getUserById(@PathVariable String id) throws NotFoundException {
        User user = userService.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new NotFoundException();
        }
    }

    @RequestMapping(method = POST)
    public String createUser(@RequestBody User user) {
        return userService.createUser(user).getUserId();
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public User updateUserById(@PathVariable String id, @RequestBody User newUser) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.updateUser(id, newUser);
        } else {
            createUser(newUser);
        }
        return user;
    }

    @RequestMapping(method = POST, path = "/login")
    public String login(@RequestBody UserLogin userLogin) {
        if (userService.login(userLogin)) {
            return "Logged in successful!";
        } else {
            throw new UnauthorizedException();
        }
    }
}
