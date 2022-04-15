package com.example.checklist.controller;

import com.example.checklist.model.User;
import com.example.checklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Optional<User> add(@RequestBody User user){
      //  Optional<User> userCreated=userService.userSave(user);
        return userService.userSave(user);

    }

    @GetMapping("/")
    public List<User> findAll(){
        List<User> users= userService.findAll();
        return users;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        userService.DeleteId(id);
    }

    @PutMapping("/update")
    public User UpdateUser(@RequestBody User user){
        return userService.UpdateUser(user, user.getId());
    }

    @GetMapping("/count")
    public Long countUsers(){
        return userService.countUsers();
    }
}
