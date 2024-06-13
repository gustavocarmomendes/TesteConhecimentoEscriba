package com.trabalhojava.microservice.Controller;

import com.trabalhojava.microservice.Entity.Cartorio;
import com.trabalhojava.microservice.Service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cartorios")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @GetMapping
    public Page<Cartorio> listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return cartorioService.listAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartorio> getById(@PathVariable int id) {
        Optional<Cartorio> cartorio = cartorioService.getById(id);
        return cartorio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cartorio create(@RequestBody Cartorio cartorio) {
        return cartorioService.save(cartorio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> update(@PathVariable int id, @RequestBody Cartorio cartorioDetails) {
        Optional<Cartorio> optionalCartorio = cartorioService.getById(id);
        if (!optionalCartorio.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cartorio cartorio = optionalCartorio.get();
        cartorio.setNome(cartorioDetails.getNome());
        cartorio.setObservacao(cartorioDetails.getObservacao());
        cartorio.setSituacao(cartorioDetails.getSituacao());
        cartorio.setAtribuicoes(cartorioDetails.getAtribuicoes());
        Cartorio updatedCartorio = cartorioService.save(cartorio);
        return ResponseEntity.ok(updatedCartorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (cartorioService.getById(id).isPresent()) {
            try {
                cartorioService.deleteById(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.status(409).body(null); // Conflict
            }
        }
        return ResponseEntity.notFound().build();
    }
}
