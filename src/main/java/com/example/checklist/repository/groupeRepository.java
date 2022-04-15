package com.example.checklist.repository;

import com.example.checklist.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupeRepository extends JpaRepository<Groupe,Long> {
}
