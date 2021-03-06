package com.example.checklist.service;

import com.example.checklist.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public Optional<Role> roleSave (Role role);
    public List<Role> findAll();
    public void DeleteId(Long id);
    public Role UpdateRole(Role role, Long id);
    public long countRoles();
}
