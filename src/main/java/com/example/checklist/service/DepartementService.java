package com.example.checklist.service;

import com.example.checklist.model.Departement;
import com.example.checklist.model.User;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    public Optional<Departement> DepartementSave (Departement departement );
    public List<Departement> findAll();
    public void DeleteId(Long id);
    public Departement UpdateDepartement(Departement departement,int id);
    public long countDepartement();
}
