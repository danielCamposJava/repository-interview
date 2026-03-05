package com.example.ejb;

import com.example.backend.entity.Beneficio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.OptimisticLockException;

import java.math.BigDecimal;

@Stateless
public class BeneficioEjbService {

    @PersistenceContext
    private EntityManager em;

    public void transfer(Long fromId, Long toId, BigDecimal amount) {


        Beneficio from = em.find(Beneficio.class, fromId);
        Beneficio to   = em.find(Beneficio.class, toId);


        if (from.getValor().compareTo(amount) < 0) {

            throw new IllegalArgumentException("Saldo insuficiente para transferência");

        }


        from.setValor(from.getValor().subtract(amount));
        to.setValor(to.getValor().add(amount));

        try {

            em.merge(from);
            em.merge(to);
            em.flush();

        } catch (OptimisticLockException e) {
            throw new RuntimeException("Erro de concorrência: outra transferência alterou os valores ao mesmo tempo", e);
        }
    }
}