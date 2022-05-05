package com.example.checklist.controller;

import com.example.checklist.model.UserDao;
import com.example.checklist.service.JwtUserDetailsService;
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
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @PostMapping("/add")
    public UserDao add(@RequestBody UserDao userDao){
        userDao.setPassword("123");

        System.out.println(userDao);
        return userDetailsService.save(userDao);

    }
    @CrossOrigin
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

    @PutMapping("/passwordChange")
    public UserDao changePassword(@RequestBody UserDao userDao)
    {
            return userService.changePassword(userDao,userDao.getId());
    }
    @GetMapping("/count")
    public Long countUsers(){
        return userService.countUsers();
    }
}
