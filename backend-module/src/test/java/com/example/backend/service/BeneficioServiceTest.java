package com.example.backend.service;


import com.example.ejb.BeneficioEjbService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BeneficioServiceTest {

    @Test
    void deveLancarExcecaoQuandoSaldoInsuficiente() {

        BeneficioEjbService ejbService = mock(BeneficioEjbService.class);

        doThrow(new IllegalStateException("Saldo insuficiente"))
                .when(ejbService)
                .transfer(1L, 2L, new BigDecimal("100.00"));

        assertThrows(IllegalStateException.class, () ->
                ejbService.transfer(1L, 2L, new BigDecimal("100.00"))
        );
    }
}