package com.LojaControl.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;
}
