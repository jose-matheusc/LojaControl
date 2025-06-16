package com.LojaControl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String codigo;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private BigDecimal precoPromocional;
    private LocalDate dataValidade;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;
}
