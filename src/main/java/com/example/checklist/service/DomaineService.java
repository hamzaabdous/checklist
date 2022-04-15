package com.example.checklist.service;

import com.example.checklist.model.Domaine;

import java.util.List;
import java.util.Optional;

public interface DomaineService {
    public Optional<Domaine> domaineSave (Domaine domaine );
    public List<Domaine> findAll();
    public void DeleteId(Long id);
    public Domaine UpdateDomaine(Domaine domaine,int id);
    public long countDomaine();
}
