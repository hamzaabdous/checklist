package com.example.checklist.controller;

import com.example.checklist.model.Groupe;
import com.example.checklist.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/groupes")
public class GroupeController {
    @Autowired
    private GroupeService groupeService;

    @PostMapping("/add")
    public Optional<Groupe> groupeSave(@RequestBody Groupe groupe){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return groupeService.groupeSave(groupe);
    }

    @GetMapping("/")
    public List<Groupe> findAllGroupes(){
        List<Groupe> Groupe= groupeService.findAllGroupes();
        return Groupe;
    }

    @PostMapping("/delete/{id}")
    public void DeleteIdGroupe(@PathVariable("id") Long id){
        groupeService.DeleteIdGroupe(id);
    }

    @PutMapping("/update")
    public Groupe UpdateUser(@RequestBody Groupe groupe){
        return groupeService.UpdateGroupe(groupe, groupe.getId());
    }

    @GetMapping("/count")
    public Long countUsers(){
        return groupeService.countGroupe();
    }
}
