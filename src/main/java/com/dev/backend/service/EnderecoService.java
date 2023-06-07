package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Endereco;
import com.dev.backend.repository.EnderecoRepository;


@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco inserir(Endereco endereco){
        endereco.setDataCriacao(new Date());
        Endereco enderecoNovo = enderecoRepository.saveAndFlush(endereco);
        return enderecoNovo;
    }

    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }

    public Endereco alterar(Endereco endereco){
        endereco.setDataAtualizacao(new Date());
        return enderecoRepository.saveAndFlush(endereco);
    }

    public void excluir (Long id){
        Endereco endereco = enderecoRepository.findById(id).get();
        enderecoRepository.delete(endereco);
        
    }

}
