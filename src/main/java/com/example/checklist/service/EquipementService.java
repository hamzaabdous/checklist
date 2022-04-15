package com.example.checklist.service;

import com.example.checklist.model.Domaine;
import com.example.checklist.model.Equipement;

import java.util.List;
import java.util.Optional;

public interface EquipementService {
    public Optional<Equipement> EquipementSave (Equipement equipement );
    public List<Equipement> findAll();
    public void DeleteId(Long id);
    public Equipement UpdateEquipement(Equipement equipement,int id);
    public long countEquipement();
}
