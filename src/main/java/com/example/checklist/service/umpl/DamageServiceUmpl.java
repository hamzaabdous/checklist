package com.example.checklist.service.umpl;

import com.example.checklist.model.Damage;
import com.example.checklist.model.Departement;
import com.example.checklist.repository.damageRepository;
import com.example.checklist.repository.departementRepository;
import com.example.checklist.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class DamageServiceUmpl implements DamageService {
    @Autowired
    private damageRepository damageRepository;

    @Override
    public Optional<Damage> DamageSave(Damage damage) {
        Optional<Damage> Damage = Optional.ofNullable(damageRepository.save(damage));
        return Damage;
    }

    @Override
    public List<Damage> findAll() {
        List<Damage> Damage =  damageRepository.findAll();

        return Damage;
    }

    @Override
    public void DeleteId(Long id) {
        damageRepository.deleteById(id);

    }

    @Override
    public Damage UpdateDamage(Damage damage, int id) {
        return damageRepository.save(damage);
    }

    @Override
    public long countDamage() {
        return damageRepository.count();
    }
}
