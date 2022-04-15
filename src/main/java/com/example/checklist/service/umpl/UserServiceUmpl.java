package com.example.checklist.service.umpl;

import com.example.checklist.model.User;
import com.example.checklist.repository.userRepository;
import com.example.checklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceUmpl implements UserService {
    @Autowired
    private userRepository userRepository;

    @Override
    public Optional<User> userSave(User user) {
        Optional<User> userO = Optional.ofNullable(userRepository.save(user));
        return userO;
    }

    @Override
    public List<User> findAll() {
        List<User> userO =  userRepository.findAll();

        return userO;
    }

    @Override
    public void DeleteId(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public User UpdateUser(User user, int id) {
        return userRepository.save(user);
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

}
