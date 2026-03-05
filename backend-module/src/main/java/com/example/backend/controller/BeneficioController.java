package com.example.backend.controller;

import com.example.ejb.BeneficioEjbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/beneficios")
public class BeneficioController {

     private BeneficioEjbService service;

     public BeneficioController(BeneficioEjbService service) {
         this.service = service;
     }

     @PostMapping("/transfer")
    public ResponseEntity<Void> trasfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam BigDecimal valor
     ){
         BigDecimal amount = null;
         service.transfer(fromId, toId, amount);
         return ResponseEntity.ok().build();
     }
}
