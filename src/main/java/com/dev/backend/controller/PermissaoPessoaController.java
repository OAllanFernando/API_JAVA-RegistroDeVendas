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

import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.service.PermissaoPessoaService;

@RestController
@RequestMapping("/api/permissaoPermissaoPessoa")
public class PermissaoPessoaController {
    @Autowired
    private PermissaoPessoaService permissaoPermissaoPessoaService;

    @PostMapping("/")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa permissaoPermissaoPessoa) {
        return permissaoPermissaoPessoaService.inserir(permissaoPermissaoPessoa);
    }

    @GetMapping("/")
    public List<PermissaoPessoa> buscarTodos() {
        return permissaoPermissaoPessoaService.buscarTodos();
    }

    @PutMapping("/")
    public PermissaoPessoa alterar(@RequestBody PermissaoPessoa permissaoPermissaoPessoa) {
        return permissaoPermissaoPessoaService.alterar(permissaoPermissaoPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoPermissaoPessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
