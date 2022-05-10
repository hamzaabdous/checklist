package com.example.checklist.controller;

import com.example.checklist.model.Equipement;
import com.example.checklist.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    @PostMapping("/add")
    public Optional<Equipement> domainSave(@RequestBody Equipement equipement){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return equipementService.EquipementSave(equipement);
    }

    @GetMapping("/")
    public List<Equipement> findAll(){
        List<Equipement> Equipement= equipementService.findAll();
        return Equipement;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        equipementService.DeleteId(id);
    }

    @PutMapping("/update")
    public Equipement UpdateDomain(@RequestBody Equipement equipement){
        return equipementService.UpdateEquipement(equipement, equipement.getId());
    }

    @GetMapping("/count")
    public Long countDomain(){
        return equipementService.countEquipement();
    }
}
