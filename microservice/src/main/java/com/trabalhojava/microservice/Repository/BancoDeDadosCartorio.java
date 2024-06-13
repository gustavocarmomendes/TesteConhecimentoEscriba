package com.trabalhojava.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhojava.microservice.Entity.Cartorio;

public interface BancoDeDadosCartorio extends JpaRepository<Cartorio, Integer> {
    
}
