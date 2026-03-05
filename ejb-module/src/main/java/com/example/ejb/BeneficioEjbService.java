package com.example.ejb;

import com.example.ejb.entity.Beneficio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;

@Stateless
public class BeneficioEjbService {

    @PersistenceContext
    private EntityManager em;

    public void transfer(Long fromId, Long toId, BigDecimal amount) {

      if(fromId.equals(toId)){
      throw  new IllegalArgumentException("a transferencia no poded ser igual");
      }

      if( amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 ){
          throw new IllegalArgumentException("a transferencia no pode ser igual");
      }

        Beneficio from = null;
        Beneficio to = null;
        if( from == null  ||  to == null ){
          throw new IllegalArgumentException("a transferencia não pode ser igual");
      }
        if (from.getValor().compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        from.setValor(from.getValor().subtract(amount));
        to.setValor(to.getValor().add(amount));

        em.persist(from);
        em.persist(to);
    }
}