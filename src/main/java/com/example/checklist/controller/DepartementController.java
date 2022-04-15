package com.example.checklist.controller;

import com.example.checklist.model.Departement;
import com.example.checklist.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @PostMapping("/add")
    public Optional<Departement> add(@RequestBody Departement departement){
        //  Optional<User> userCreated=userService.userSave(user);
        return departementService.DepartementSave(departement);

    }

    @GetMapping("/")
    public List<Departement> findAll(){
        List<Departement> Departements= departementService.findAll();
        return Departements;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        departementService.DeleteId(id);
    }

    @PutMapping("/update")
    public Departement UpdateDepartement(@RequestBody Departement departement){
        return departementService.UpdateDepartement(departement, departement.getId());
    }

    @GetMapping("/count")
    public Long countDepartement(){
        return departementService.countDepartement();
    }
}
