package com.example.checklist.repository;

import com.example.checklist.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface departementRepository  extends JpaRepository<Departement,Long> {
}
