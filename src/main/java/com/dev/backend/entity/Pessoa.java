package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{nome.not.blank}")
    @NotNull
    private String nome;
    @NotBlank(message = "{email.not.blank}")
    private String email;
    private String senha;
    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for (PermissaoPessoa p : pp) {
            p.setPessoa(this);
        }
        this.permissaoPessoas = pp;
    }
}
