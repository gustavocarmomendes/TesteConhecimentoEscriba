package com.trabalhojava.microservice.Service;

import com.trabalhojava.microservice.Entity.Cartorio;
import com.trabalhojava.microservice.Repository.BancoDeDadosCartorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartorioService {

    @Autowired
    private BancoDeDadosCartorio cartorioRepository;

    public Page<Cartorio> listAll(int page, int size) {
        return cartorioRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Cartorio> getById(int id) {
        return cartorioRepository.findById(id);
    }

    public Cartorio save(Cartorio cartorio) {
        return cartorioRepository.save(cartorio);
    }

    public void deleteById(int id) {
        cartorioRepository.deleteById(id);
    }
}
