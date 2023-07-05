package com.dev.backend.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.EnderecoService;
import com.dev.backend.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    private EnderecoService enderecoService;

    @PostMapping("/")
    public Pessoa inserir(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.inserir(pessoa);
    }

    @GetMapping("/")
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa pessoa) {
        return pessoaService.alterar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    // localhost:8080/api/pessoa/nome-pessoa?nome=Fulano Fernando
    @GetMapping("/nome-pessoa")
    public List<Pessoa> buscarPessoaPorNome(@PathParam("nome") String nome) {
        return pessoaService.buscarPessoaPorNome(nome);
    }

    @GetMapping("/pessoa/{id}")
    public List<Endereco> buscarPessoaPorEndereco(@PathParam("id") Long id) {
        return enderecoService.enderecoPorPessoa(id);
    }

}
