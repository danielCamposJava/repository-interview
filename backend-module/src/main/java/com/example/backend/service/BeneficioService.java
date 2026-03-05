package com.example.backend.service;

import com.example.backend.repository.BeneficioRepository;
import com.example.ejb.BeneficioEjbService;
import com.example.ejb.entity.Beneficio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficioService {

    private final BeneficioRepository repository;
    private final BeneficioEjbService ejbService;

    public BeneficioService(BeneficioRepository repository,
                            BeneficioEjbService ejbService) {
        this.repository = repository;
        this.ejbService = ejbService;
    }

    public List<com.example.ejb.entity.Beneficio> findAll() {
        return repository.findAll();
    }

    public Optional<com.example.ejb.entity.Beneficio> findById(Long id) {
        return repository.findById(id);
    }

    public com.example.ejb.entity.Beneficio save(Beneficio beneficio) {
        return repository.save(beneficio);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        ejbService.transfer(fromId, toId, amount);
    }
}