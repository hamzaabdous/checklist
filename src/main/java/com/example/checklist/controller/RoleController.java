package com.example.checklist.controller;

import com.example.checklist.model.Role;
import com.example.checklist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Optional<Role> add(@RequestBody Role role){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return roleService.roleSave(role);

    }

    @GetMapping("/")
    public List<Role> findAll(){
        List<Role> roles= roleService.findAll();
        return roles;
    }

    @PostMapping("/delete/{id}")
    public void DeleteId(@PathVariable("id") Long id){
        roleService.DeleteId(id);
    }

    @PutMapping("/update")
    public Role UpdateRole(@RequestBody Role role){
        return roleService.UpdateRole(role, role.getId());
    }

    @GetMapping("/count")
    public Long countRoles(){
        return roleService.countRoles();
    }
}
