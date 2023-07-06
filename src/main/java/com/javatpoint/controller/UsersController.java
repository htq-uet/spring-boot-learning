package com.javatpoint.controller;

import com.javatpoint.exception.UserNotFoundException;
import com.javatpoint.model.Users;
import com.javatpoint.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("")
    private List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{userId}")
    private Users getUser(@PathVariable("userId") int userId) {
        return usersService.getUsersById(userId);
    }

    @GetMapping("/hp/{userHp}")
    private Users getUserByHp(@PathVariable("userHp") int userHp) {
        return usersService.getUsersByHp(userHp);
    }

    @DeleteMapping("delete/{userId}")
    private void deleteUser(@PathVariable("userId") int userId) {

        Users user = usersService.deleteUser(userId);
        if(user == null){
            throw new UserNotFoundException("id: " + userId);
        }
    }

    @PostMapping("")
    private ResponseEntity<Users> saveUser(@Valid @RequestBody Users users) {
        Users savedUser = usersService.saveOrUpdate(users);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("")
    private ResponseEntity<Users> updateUser(@Valid @RequestBody Users users) {
        Users savedUser = usersService.saveOrUpdate(users);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
