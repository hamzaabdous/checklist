package com.example.checklist.repository;

import com.example.checklist.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface equipementRepository extends JpaRepository<Equipement,Long> {
}
