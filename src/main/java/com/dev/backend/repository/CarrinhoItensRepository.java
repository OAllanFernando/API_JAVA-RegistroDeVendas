package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.CarrinhoItens;

public interface CarrinhoItensRepository extends JpaRepository<CarrinhoItens, Long> {

}
