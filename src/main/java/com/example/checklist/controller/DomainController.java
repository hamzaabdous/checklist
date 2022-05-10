package com.example.checklist.controller;


import com.example.checklist.model.Domain;
import com.example.checklist.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domains")
public class DomainController {
    @Autowired
    private DomainService domainService;

    @PostMapping("/add")
    public Optional<Domain> domainSave(@RequestBody Domain domain){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return domainService.domainSave(domain);
    }

    @GetMapping("/")
    public List<Domain> findAll(){
        List<Domain> domain = domainService.findAll();
        return domain;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        domainService.DeleteId(id);
    }

    @PutMapping("/update")
    public Domain UpdateDomain(@RequestBody Domain domain){
        return domainService.UpdateDomain(domain, domain.getId());
    }

    @GetMapping("/count")
    public Long countDomain(){
        return domainService.countDomain();
    }
}
