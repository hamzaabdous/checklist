package com.example.checklist.service;

import com.example.checklist.model.UserDao;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<UserDao> userSave (UserDao userDao);
    public List<UserDao> findAll();
    public void DeleteId(Long id);
    public UserDao UpdateUser(UserDao userDao, Long id);
    public long countUsers();
    public UserDao changePassword(UserDao userDao, Long id);
    public Optional<UserDao> findById(Long id);
}
