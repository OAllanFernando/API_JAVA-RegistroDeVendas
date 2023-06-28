package com.dev.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.backend.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("from Endereco where pessoa.id=?1")
    public List<Endereco> enderecoPorPessoa(Long idPessoa);

   

}
