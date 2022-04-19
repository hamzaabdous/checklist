package com.example.checklist.service.umpl;

import com.example.checklist.model.Damage;
import com.example.checklist.model.DamageType;
import com.example.checklist.repository.damageRepository;
import com.example.checklist.repository.damageTypeRepository;
import com.example.checklist.service.DamageService;
import com.example.checklist.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DamageTypeServiceUmpl implements DamageTypeService {

    @Autowired
    private damageTypeRepository damageTypeRepository;


    @Override
    public Optional<DamageType> DamageTypeSave(DamageType damageType) {
        Optional<DamageType> damageType1 = Optional.ofNullable(damageTypeRepository.save(damageType));
        return damageType1;
    }

    @Override
    public List<DamageType> findAll() {
        List<DamageType> DamageType =  damageTypeRepository.findAll();

        return DamageType;
    }

    @Override
    public void DeleteId(Long id) {
        damageTypeRepository.deleteById(id);

    }

    @Override
    public DamageType UpdateDamageType(DamageType damageType, int id) {
        return damageTypeRepository.save(damageType);
    }

    @Override
    public long countDamageType() {
        return damageTypeRepository.count();
    }
}
