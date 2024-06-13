package com.trabalhojava.microservice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Atribuicao {
    @Id
    private String id;
    private String nome;
    private boolean situacao = true;
}
