package com.example.checklist.controller;


import com.example.checklist.model.Departement;
import com.example.checklist.model.Domaine;
import com.example.checklist.service.DepartementService;
import com.example.checklist.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Damages")
public class DamageController {
    @Autowired
    private DomaineService domaineService;

    @PostMapping("/add")
    public Optional<Domaine> add(@RequestBody Domaine domaine){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return domaineService.domaineSave(domaine);
    }

    @GetMapping("/")
    public List<Domaine> findAll(){
        List<Domaine> Domaine= domaineService.findAll();
        return Domaine;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        domaineService.DeleteId(id);
    }

    @PutMapping("/update")
    public Domaine UpdateDepartement(@RequestBody Domaine domaine){
        return domaineService.UpdateDomaine(domaine, domaine.getId());
    }

    @GetMapping("/count")
    public Long countDepartement(){
        return domaineService.countDomaine();
    }
}
