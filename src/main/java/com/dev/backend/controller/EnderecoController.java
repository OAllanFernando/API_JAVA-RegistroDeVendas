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

import com.dev.backend.entity.Endereco;
import com.dev.backend.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/")
    public Endereco inserir (@RequestBody Endereco endereco){
        return enderecoService.inserir(endereco);
    }

    @GetMapping("/")
    public List<Endereco> buscarTodos() {
        return enderecoService.buscarTodos();
    }

    @PutMapping("/")
    public Endereco alterar(@RequestBody Endereco endereco) {
        return enderecoService.alterar(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        enderecoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
