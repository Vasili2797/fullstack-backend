package com.codewitharjun.fullstack_backend.controller;

import com.codewitharjun.fullstack_backend.model.User;
import com.codewitharjun.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// this is a specialized version of controller annotation. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation. Since controller is annotated ith the @Restcontroller annotation, the @ResponseBody isn't required
@RestController
public class UserController {
    // One of the core annotations in Spring, used for automatic dependency injection. In simpler terms, it allows Spring to automatically wire the required beans (dependencies) into your classes, eliminating the need for manual configuration. Spring will attempt to find a matching bean in the application context and inject it into the annotated component.
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll(); // This is given by JPA
    }
}
