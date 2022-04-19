package com.example.checklist.controller;

import com.example.checklist.model.DamageType;
import com.example.checklist.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DamageTypes")
public class DamageTypeController {
    @Autowired
    private DamageTypeService damageTypeService;

    @PostMapping("/add")
    public Optional<DamageType> add(@RequestBody DamageType damageType){
        return damageTypeService.DamageTypeSave(damageType);
    }

    @GetMapping("/")
    public List<DamageType> findAll(){
        List<DamageType> DamageType= damageTypeService.findAll();
        return DamageType;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        damageTypeService.DeleteId(id);
    }

    @PutMapping("/update")
    public DamageType UpdateDamageType(@RequestBody DamageType damageType){
        return damageTypeService.UpdateDamageType(damageType, damageType.getId());
    }

    @GetMapping("/count")
    public Long countDamageType(){
        return damageTypeService.countDamageType();
    }
}
