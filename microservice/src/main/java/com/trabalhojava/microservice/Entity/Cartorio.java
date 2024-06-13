package com.trabalhojava.microservice.Entity;

import javax.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "situacao_id", nullable = false)
    private Situacao situacao;

    @ManyToMany
    @JoinTable(
        name = "cartorio_atribuicao",
        joinColumns = @JoinColumn(name = "cartorio_id"),
        inverseJoinColumns = @JoinColumn(name = "atribuicao_id")
    )
    private List<Atribuicao> atribuicoes;
}

