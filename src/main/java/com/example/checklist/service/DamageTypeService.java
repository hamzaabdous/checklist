package com.example.checklist.service;

import com.example.checklist.model.DamageType;

import java.util.List;
import java.util.Optional;

public interface DamageTypeService {
    public Optional<DamageType> DamageTypeSave (DamageType damageType );
    public List<DamageType> findAll();
    public void DeleteId(Long id);
    public DamageType UpdateDamageType(DamageType damageType, Long id);
    public long countDamageType();
}
