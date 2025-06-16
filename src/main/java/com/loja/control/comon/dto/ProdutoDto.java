package com.loja.control.comon.dto;

public record ProdutoDto(String nome,
                         String codigo,
                         String descricao,
                         Double preco,
                         Long categoriaId,
                         Long fornecedorId) {

    public ProdutoDto(String nome, String codigo, String descricao, Double preco) {
        this(nome, codigo, descricao, preco, null, null);
    }

    public ProdutoDto(String nome, String codigo) {
        this(nome, codigo, null, null, null, null);
    }
}
