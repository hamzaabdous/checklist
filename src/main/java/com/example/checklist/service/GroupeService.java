package com.example.checklist.service;

import com.example.checklist.model.Groupe;

import java.util.List;
import java.util.Optional;

public interface GroupeService {
    public Optional<Groupe> groupeSave (Groupe groupe );
    public List<Groupe> findAllGroupes();
    public void DeleteIdGroupe(Long id);
    public Groupe UpdateGroupe(Groupe groupe,int id);
    public long countGroupe();
}
