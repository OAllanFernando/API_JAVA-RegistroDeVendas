package com.dev.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    
    
    @Query("from Pessoa where nome like %?1%")
    public List<Pessoa> buscaPessoaPorNome(String pessoa); 
    
    
}
