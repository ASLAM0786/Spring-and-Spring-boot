package com.aslam.rest.webservices.restfulwebservices.jpa;

import com.aslam.rest.webservices.restfulwebservices.PostRepository;
import com.aslam.rest.webservices.restfulwebservices.UserRepository;
import com.aslam.rest.webservices.restfulwebservices.user.Post;
import com.aslam.rest.webservices.restfulwebservices.user.User;
import com.aslam.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserJpaResource(PostRepository postRepository, UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(" id " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User newuser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newuser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> getAllPostOfAnUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(" id " + id);
        }
        return user.get().getPosts();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Object> addPostOfAnUser(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(" id " + id);
        }

        post.setUser(user.get());
        Post savePost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //http://localhost:8000/jpa/users/10001/posts/1

    @GetMapping(path = "jpa/users/{id}/posts/{post_id}")
    public Post getPostById(@PathVariable Integer id, @PathVariable Integer post_id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(" id " + id);
        }
        return postRepository.findById(post_id).get();
    }
}
