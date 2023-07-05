package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Imagem;
import com.dev.backend.repository.ImagemRepository;


@Service
public class ImagemService {
    
    @Autowired
    private ImagemRepository imagemRepository;

    public Imagem inserir(Imagem imagem){
        imagem.setDataCriacao(new Date());
        Imagem imagemNovo = imagemRepository.saveAndFlush(imagem);
        return imagemNovo;
    }

    public List<Imagem> buscarTodos(){
        return imagemRepository.findAll();
    }

    public Imagem alterar(Imagem imagem){
        imagem.setDataAtualizacao(new Date());
        return imagemRepository.saveAndFlush(imagem);
    }

    public void excluir (Long id){
        Imagem imagem = imagemRepository.findById(id).get();
        imagemRepository.delete(imagem);
        
    }

}
