package com.dmrtech.monolith.controllers;

import com.dmrtech.monolith.model.User;
import com.dmrtech.monolith.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public User findById(@PathVariable long id) throws NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Calendar event not found with id: " + id));

    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    Iterable<User> all() {
        return userRepository.findAll();
    }


    @PostMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    User upsert(Principal principal, @RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setId(newUser.getId());
                    user.setUsername(user.getUsername());
                    user.setPassword(user.getPassword());

                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
