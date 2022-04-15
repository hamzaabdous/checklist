package com.example.checklist.repository;

import com.example.checklist.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface domaineRepository extends JpaRepository<Domaine,Long> {
}
