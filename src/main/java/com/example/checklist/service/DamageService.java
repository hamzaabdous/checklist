package com.example.checklist.service;

import com.example.checklist.model.Damage;
import com.example.checklist.model.Departement;

import java.util.List;
import java.util.Optional;

public interface DamageService {
    public Optional<Damage> DamageSave (Damage damage );
    public List<Damage> findAll();
    public void DeleteId(Long id);
    public Damage UpdateDamage(Damage damage,int id);
    public long countDamage();
}
