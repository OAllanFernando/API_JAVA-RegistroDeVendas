package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Carrinho;
import com.dev.backend.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho inserir(Carrinho carrinho) {
        carrinho.setDataCriacao(new Date());
        Carrinho carrinhoNovo = carrinhoRepository.saveAndFlush(carrinho);
        return carrinhoNovo;
    }

    public List<Carrinho> buscarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho alterar(Carrinho carrinho) {
        carrinho.setDataAtualizacao(new Date());
        return carrinhoRepository.saveAndFlush(carrinho);
    }

    public void excluir(Long id) {
        Carrinho carrinho = carrinhoRepository.findById(id).get();
        carrinhoRepository.delete(carrinho);

    }

}
