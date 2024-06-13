package com.trabalhojava.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhojava.microservice.Entity.Atribuicao;

public interface BancoDeDadosAtribuicao extends JpaRepository<Atribuicao, String> {
    
}
