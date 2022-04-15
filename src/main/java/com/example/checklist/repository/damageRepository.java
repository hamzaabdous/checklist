package com.example.checklist.repository;

import com.example.checklist.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface damageRepository extends JpaRepository<Damage,Long> {
}
