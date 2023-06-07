package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
