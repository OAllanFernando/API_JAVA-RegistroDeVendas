package com.dev.backend.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.dev.backend.entity.Estado;
import com.dev.backend.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @PostMapping("/")
    public Estado inserir(@Valid @RequestBody Estado estado) {
        return estadoService.inserir(estado);
    }

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoService.buscarTodos();
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {
        return estadoService.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
