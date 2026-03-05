package com.example.backend.service;

import com.example.backend.entity.Beneficio;
import com.example.backend.repository.BeneficioRepository;
import com.example.ejb.BeneficioEjbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BeneficioServiceTest {

    @Autowired
    private BeneficioRepository repository;

    @Autowired
    private BeneficioEjbService ejbService;

    private BeneficioService service;

    private Beneficio beneficio1;
    private Beneficio beneficio2;

    @BeforeEach
    void setup() {
        service = new BeneficioService(repository, ejbService);

        beneficio1 = new Beneficio();
        beneficio1.setValor(new BigDecimal("1000"));
        repository.save(beneficio1);

        beneficio2 = new Beneficio();
        beneficio2.setValor(new BigDecimal("500"));
        repository.save(beneficio2);
    }

    @Test
    void testFindAll() {
        assertEquals(2, service.findAll().size());
    }

    @Test
    void testFindById() {
        Optional<Beneficio> found = service.findById(beneficio1.getId());
        assertTrue(found.isPresent());
        assertEquals(new BigDecimal("1000"), found.get().getValor());
    }

    @Test
    void testSaveAndDelete() {
        Beneficio b = new Beneficio();
        b.setValor(new BigDecimal("300"));
        Beneficio saved = service.save(b);

        assertNotNull(saved.getId());
        assertEquals(3, service.findAll().size());

        service.delete(saved.getId());
        assertEquals(2, service.findAll().size());
    }

    @Test
    void testTransferSucesso() {
        service.transfer(beneficio1.getId(), beneficio2.getId(), new BigDecimal("200"));

        Beneficio fromUpdated = repository.findById(beneficio1.getId()).get();
        Beneficio toUpdated   = repository.findById(beneficio2.getId()).get();

        assertEquals(new BigDecimal("800"), fromUpdated.getValor());
        assertEquals(new BigDecimal("700"), toUpdated.getValor());
    }

    @Test
    void testTransferSaldoInsuficiente() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                service.transfer(beneficio2.getId(), beneficio1.getId(), new BigDecimal("1000"))
        );

        assertEquals("Saldo insuficiente para transferência", ex.getMessage());
    }
}