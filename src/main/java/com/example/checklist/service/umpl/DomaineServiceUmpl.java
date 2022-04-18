package com.example.checklist.service.umpl;

import com.example.checklist.model.Domaine;
import com.example.checklist.repository.domaineRepository;
import com.example.checklist.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DomaineServiceUmpl implements DomaineService {
    @Autowired
    private domaineRepository domaineRepository;

    @Override
    public Optional<Domaine> domaineSave(Domaine domaine) {
        Optional<Domaine> Domaine = Optional.ofNullable(domaineRepository.save(domaine));
        return Domaine;    }

    @Override
    public List<Domaine> findAll() {
        return domaineRepository.findAll();
    }

    @Override
    public void DeleteId(Long id) {
        domaineRepository.deleteById(id);
    }

    @Override
    public Domaine UpdateDomaine(Domaine domaine, int id) {
        return domaineRepository.save(domaine);
    }

    @Override
    public long countDomaine() {
        return domaineRepository.count();
    }
}
