package com.example.checklist.repository;

import com.example.checklist.model.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface damageTypeRepository extends JpaRepository<DamageType,Long> {
}
