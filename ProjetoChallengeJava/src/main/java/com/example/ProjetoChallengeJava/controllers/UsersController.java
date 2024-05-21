package com.example.ProjetoChallengeJava.controllers;

import com.example.ProjetoChallengeJava.domain.users.RequestUsers;
import com.example.ProjetoChallengeJava.domain.users.Users;
import com.example.ProjetoChallengeJava.domain.users.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository repository;
    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity registerUsers(@RequestBody @Validated RequestUsers data){
        Users newUser = new Users(data);
        System.out.println(data);
        repository.save(newUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUsers(@RequestBody @Validated RequestUsers data){
        Optional<Users> optionalUsers = repository.findById(data.id());
        if (optionalUsers.isPresent()){
            Users users = optionalUsers.get();
            users.setName(data.name());
            return ResponseEntity.ok(users);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUsers(@PathVariable String id){
        Optional<Users> optionalUsers = repository.findById(id);
        if (optionalUsers.isPresent()){
            Users users = optionalUsers.get();
            users.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
