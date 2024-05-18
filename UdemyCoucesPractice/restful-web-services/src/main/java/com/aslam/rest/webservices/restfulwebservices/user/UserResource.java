package com.aslam.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(" id " + id);
        }

        return user;

    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User newuser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newuser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDaoService.deleteById(id);
    }
}
