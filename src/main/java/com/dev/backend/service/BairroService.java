package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Bairro;
import com.dev.backend.repository.BairroRepository;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public Bairro inserir(Bairro bairro) {
        bairro.setDataCriacao(new Date());
        Bairro bairroNovo = bairroRepository.saveAndFlush(bairro);
        return bairroNovo;
    }

    public List<Bairro> buscarTodos() {
        return bairroRepository.findAll();
    }

    public Bairro alterar(Bairro bairro) {
        bairro.setDataAtualizacao(new Date());
        return bairroRepository.saveAndFlush(bairro);
    }

    public void excluir(Long id) {
        Bairro bairro = bairroRepository.findById(id).get();
        bairroRepository.delete(bairro);

    }

}
