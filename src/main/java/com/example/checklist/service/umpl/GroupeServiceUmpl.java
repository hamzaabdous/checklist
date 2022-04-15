package com.example.checklist.service.umpl;

import com.example.checklist.model.Domaine;
import com.example.checklist.model.Groupe;
import com.example.checklist.repository.domaineRepository;
import com.example.checklist.repository.groupeRepository;
import com.example.checklist.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GroupeServiceUmpl implements GroupeService {
    @Autowired
    private groupeRepository groupeRepository;


    @Override
    public Optional<Groupe> groupeSave(Groupe groupe) {
        Optional<Groupe> Groupe = Optional.ofNullable(groupeRepository.save(groupe));
        return Groupe;    }

    @Override
    public List<Groupe> findAllGroupes() {
        return groupeRepository.findAll();
    }



    @Override
    public void DeleteIdGroupe(Long id) {
        groupeRepository.deleteById(id);
    }

    @Override
    public Groupe UpdateGroupe(Groupe groupe, int id) {
        return groupeRepository.save(groupe);
    }

    @Override
    public long countGroupe() {
        return groupeRepository.count();
    }
}
