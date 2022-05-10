package com.example.checklist.service.umpl;

import com.example.checklist.model.Role;
import com.example.checklist.repository.roleRepository;
import com.example.checklist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceUmpl implements RoleService {
    @Autowired
    private roleRepository roleRepository;
    @Override
    public Optional<Role> roleSave(Role role) {
        Optional<Role> role1 = Optional.of(roleRepository.save(role));
        return role1;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void DeleteId(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role UpdateRole(Role role, Long id) {
        return roleRepository.save(role);
    }

    @Override
    public long countRoles() {
        return roleRepository.count();
    }
}
