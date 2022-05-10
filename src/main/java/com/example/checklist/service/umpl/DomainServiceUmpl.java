package com.example.checklist.service.umpl;

import com.example.checklist.model.Domain;
import com.example.checklist.repository.domainRepository;
import com.example.checklist.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DomainServiceUmpl implements DomainService {
    @Autowired
    private domainRepository domainRepository;

    @Override
    public Optional<Domain> domainSave(Domain domain) {
        Optional<Domain> Domain = Optional.ofNullable(domainRepository.save(domain));
        return Domain;    }

    @Override
    public List<Domain> findAll() {
        return domainRepository.findAll();
    }

    @Override
    public void DeleteId(Long id) {
        domainRepository.deleteById(id);
    }

    @Override
    public Domain UpdateDomain(Domain domain, int id) {
        return domainRepository.save(domain);
    }

    @Override
    public long countDomain() {
        return domainRepository.count();
    }
}
