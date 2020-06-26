package com.edureka.userms.resource;

import com.edureka.userms.model.User;
import com.edureka.userms.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
//@RequestMapping("/api/v1")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers(@RequestHeader(name = "x-location", required = false) String location) {
        System.out.println("x-location: " + location);
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getAllUsers(@PathVariable Long userId) {
        Optional<User> user = userService.getSingleUser(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();
    }

    /*@DeleteMapping
    @PutMapping
    @PatchMapping
    */

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
        User userCreated = userService.createUser(user);
        return ResponseEntity.created(new URI(userCreated.getId().toString())).build();
    }

    @GetMapping("/allOrders")
    public Object getAllOrders() {
        return userService.getAllOrders();
    }
}
