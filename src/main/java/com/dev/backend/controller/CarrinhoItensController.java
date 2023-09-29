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

import com.dev.backend.entity.CarrinhoItens;
import com.dev.backend.service.CarrinhoItensService;

@RestController
@RequestMapping("/api/carrinhoitens")
public class CarrinhoItensController {
    @Autowired
    private CarrinhoItensService carrinhoItensService;

    @PostMapping("/")
    public CarrinhoItens inserir(@RequestBody CarrinhoItens carrinhoItens) {
        return carrinhoItensService.inserir(carrinhoItens);
    }

    @GetMapping("/")
    public List<CarrinhoItens> buscarTodos() {
        return carrinhoItensService.buscarTodos();
    }

    @PutMapping("/")
    public CarrinhoItens alterar(@RequestBody CarrinhoItens carrinhoItens) {
        return carrinhoItensService.alterar(carrinhoItens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        carrinhoItensService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
