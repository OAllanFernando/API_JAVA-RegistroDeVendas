package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Carrinho;
import com.dev.backend.service.CarrinhoService;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/")
    public Carrinho inserir(@RequestBody Carrinho carrinho) {
        return carrinhoService.inserir(carrinho);
    }

    @GetMapping("/")
    public List<Carrinho> buscarTodos() {
        return carrinhoService.buscarTodos();
    }

    @PutMapping("/")
    public Carrinho alterar(@RequestBody Carrinho carrinho) {
        return carrinhoService.alterar(carrinho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        carrinhoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
