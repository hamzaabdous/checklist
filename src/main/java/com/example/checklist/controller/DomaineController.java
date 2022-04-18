package com.example.checklist.controller;


import com.example.checklist.model.Domaine;
import com.example.checklist.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domaines")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @PostMapping("/add")
    public Optional<Domaine> domaineSave(@RequestBody Domaine domaine){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return domaineService.domaineSave(domaine);
    }

    @GetMapping("/")
    public List<Domaine> findAll(){
        List<Domaine> domaine= domaineService.findAll();
        return domaine;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        domaineService.DeleteId(id);
    }

    @PutMapping("/update")
    public Domaine UpdateDomaine(@RequestBody Domaine domaine){
        return domaineService.UpdateDomaine(domaine, domaine.getId());
    }

    @GetMapping("/count")
    public Long countDomaine(){
        return domaineService.countDomaine();
    }
}
