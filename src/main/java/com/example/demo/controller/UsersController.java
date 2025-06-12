package com.example.demo.controller;

import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@Valid @RequestBody UserRequestDTO users){
        Users user = new Users();
        user.setName(users.getName());
        user.setEmail(users.getEmail());
        return ResponseEntity.ok(userRepository.save(user));
    }
}
