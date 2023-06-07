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

import com.dev.backend.entity.Imagem;
import com.dev.backend.service.ImagemService;

@RestController
@RequestMapping("/api/imagem")
public class ImagemController {
    @Autowired
    private ImagemService imagemService;

    @PostMapping("/")
    public Imagem inserir (@RequestBody Imagem imagem){
        return imagemService.inserir(imagem);
    }

    @GetMapping("/")
    public List<Imagem> buscarTodos() {
        return imagemService.buscarTodos();
    }

    @PutMapping("/")
    public Imagem alterar(@RequestBody Imagem imagem) {
        return imagemService.alterar(imagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        imagemService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
