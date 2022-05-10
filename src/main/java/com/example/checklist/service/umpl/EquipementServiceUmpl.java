package com.example.checklist.service.umpl;

import com.example.checklist.model.Equipement;
import com.example.checklist.repository.equipementRepository;
import com.example.checklist.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceUmpl implements EquipementService {
    @Autowired
    private equipementRepository equipementRepository;

    @Override
    public Optional<Equipement> EquipementSave(Equipement equipement) {
        Optional<Equipement> Equipement = Optional.ofNullable(equipementRepository.save(equipement));
        return Equipement;     }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public void DeleteId(Long id) {
        equipementRepository.deleteById(id);

    }

    @Override
    public Equipement UpdateEquipement(Equipement equipement, int id) {
        return equipementRepository.save(equipement);
    }

    @Override
    public long countEquipement() {
        return equipementRepository.count();
    }
}
