package com.example.checklist.service.umpl;

import com.example.checklist.model.UserDao;
import com.example.checklist.repository.userRepository;
import com.example.checklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceUmpl implements UserService {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public Optional<UserDao> userSave(UserDao userDao) {

        userDao.setPassword(bcryptEncoder.encode(userDao.getPassword()));

        Optional<UserDao> userO = Optional.ofNullable(userRepository.save(userDao));
        return userO;
    }

    @Override
    public List<UserDao> findAll() {
        List<UserDao> userDaoO =  userRepository.findAll();

        return userDaoO;
    }

    @Override
    public void DeleteId(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public UserDao UpdateUser(UserDao userDao, Long id) {
        Date currentDate = new Date();
        userDao.setUpdateDate(currentDate);
        return userRepository.save(userDao);
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

    @Override
    public UserDao changePassword(UserDao userDao, Long id) {
        userDao.setPassword(bcryptEncoder.encode(userDao.getPassword()));
        return userRepository.save(userDao);
    }

    @Override
    public Optional<UserDao> findById(Long id) {
        return userRepository.findById(id);
    }

}
