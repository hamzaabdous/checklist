package com.example.checklist.service.umpl;

import com.example.checklist.model.Departement;
import com.example.checklist.repository.departementRepository;
import com.example.checklist.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartementServiceUmpl implements DepartementService {
    @Autowired
    private departementRepository departementRepository;

    @Override
    public Optional<Departement> DepartementSave(Departement departement) {

        Optional<Departement> departement0 = Optional.ofNullable(departementRepository.save(departement));
        return departement0;
    }

    @Override
    public List<Departement> findAll() {

        List<Departement> departement0 =  departementRepository.findAll();

        return departement0;
    }

    @Override
    public void DeleteId(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement UpdateDepartement(Departement departement, Long id) {
        return departementRepository.save(departement);
    }

    @Override
    public long countDepartement() {
        return departementRepository.count();
    }
}
