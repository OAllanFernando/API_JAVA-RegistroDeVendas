package com.dev.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {

    List<Permissao> findByNome(String nome);
}
