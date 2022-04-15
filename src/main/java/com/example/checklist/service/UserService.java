package com.example.checklist.service;

import com.example.checklist.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> userSave (User user );
    public List<User> findAll();
    public void DeleteId(Long id);
    public User UpdateUser(User user,int id);
    public long countUsers();

}
