package com.example.checklist.controller;

import com.example.checklist.model.UserDao;
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
    public Optional<UserDao> add(@RequestBody UserDao userDao){
      //  Optional<UserDao> userCreated=userService.userSave(userDao);
        userDao.setPassword("123");
        return userService.userSave(userDao);

    }

    @GetMapping("/")
    public List<UserDao> findAll(){
        List<UserDao> userDaos = userService.findAll();
        return userDaos;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        userService.DeleteId(id);
    }

    @PutMapping("/update")
    public UserDao UpdateUser(@RequestBody UserDao userDao){
        return userService.UpdateUser(userDao, userDao.getId());
    }

    @GetMapping("/count")
    public Long countUsers(){
        return userService.countUsers();
    }
}
