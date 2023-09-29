package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.CarrinhoItens;
import com.dev.backend.repository.CarrinhoItensRepository;

@Service
public class CarrinhoItensService {

    @Autowired
    private CarrinhoItensRepository carrinhoItensRepository;

    public CarrinhoItens inserir(CarrinhoItens carrinhoItens) {
        carrinhoItens.setDataCriacao(new Date());
        CarrinhoItens carrinhoItensNovo = carrinhoItensRepository.saveAndFlush(carrinhoItens);
        return carrinhoItensNovo;
    }

    public List<CarrinhoItens> buscarTodos() {
        return carrinhoItensRepository.findAll();
    }

    public CarrinhoItens alterar(CarrinhoItens carrinhoItens) {
        carrinhoItens.setDataAtualizacao(new Date());
        return carrinhoItensRepository.saveAndFlush(carrinhoItens);
    }

    public void excluir(Long id) {
        CarrinhoItens carrinhoItens = carrinhoItensRepository.findById(id).get();
        carrinhoItensRepository.delete(carrinhoItens);

    }

}
