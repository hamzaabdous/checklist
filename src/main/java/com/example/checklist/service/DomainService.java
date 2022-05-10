package com.example.checklist.service;

import com.example.checklist.model.Domain;

import java.util.List;
import java.util.Optional;

public interface DomainService {
    public Optional<Domain> domainSave (Domain domain);
    public List<Domain> findAll();
    public void DeleteId(Long id);
    public Domain UpdateDomain(Domain domain, int id);
    public long countDomain();
}
