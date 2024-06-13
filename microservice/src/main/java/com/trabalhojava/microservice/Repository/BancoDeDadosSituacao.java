package com.trabalhojava.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalhojava.microservice.Entity.Situacao;

public interface BancoDeDadosSituacao extends JpaRepository<Situacao, String> {
   
}