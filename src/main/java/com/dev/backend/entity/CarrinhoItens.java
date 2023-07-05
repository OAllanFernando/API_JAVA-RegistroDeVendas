package com.dev.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "carrinho_itens")
@Data
public class CarrinhoItens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private Integer quantidade;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
