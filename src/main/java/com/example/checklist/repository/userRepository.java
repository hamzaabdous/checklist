package com.example.checklist.repository;

import com.example.checklist.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<UserDao,Long> {
    UserDao findByUsername(String username);

}
