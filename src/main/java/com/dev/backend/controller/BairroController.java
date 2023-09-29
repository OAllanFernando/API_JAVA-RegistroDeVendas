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

import com.dev.backend.entity.Bairro;
import com.dev.backend.service.BairroService;

@RestController
@RequestMapping("/api/bairro")
public class BairroController {
    @Autowired
    private BairroService bairroService;

    @PostMapping("/")
    public Bairro inserir(@Valid @RequestBody Bairro bairro) {
        return bairroService.inserir(bairro);
    }

    @GetMapping("/")
    public List<Bairro> buscarTodos() {
        return bairroService.buscarTodos();
    }

    @PutMapping("/")
    public Bairro alterar(@RequestBody Bairro bairro) {
        return bairroService.alterar(bairro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        bairroService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
