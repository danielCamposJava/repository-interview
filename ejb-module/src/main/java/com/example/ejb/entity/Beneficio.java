package com.example.ejb.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Long getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}