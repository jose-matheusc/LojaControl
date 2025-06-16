package com.loja.control.service;

import com.loja.control.entity.Produto;
import com.loja.control.respository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private static final int LIMITE_PRODUTOS = 1000;

    public Produto salvar(Produto produto) {
        if (produtoRepository.count() >= LIMITE_PRODUTOS) {
            throw new IllegalStateException("Limite de produtos atingido.");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    public Produto atualizar(Long id, Produto atualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(atualizado.getNome());
        produto.setDescricao(atualizado.getDescricao());
        produto.setPreco(atualizado.getPreco());
        produto.setQuantidadeEstoque(atualizado.getQuantidadeEstoque());
        produto.setPrecoPromocional(atualizado.getPrecoPromocional());
        produto.setDataValidade(atualizado.getDataValidade());
        produto.setCategoria(atualizado.getCategoria());
        produto.setFornecedor(atualizado.getFornecedor());
        return produtoRepository.save(produto);
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNomeOuCodigo(String termo) {
        return produtoRepository.findByNomeContainingIgnoreCaseOrCodigoContainingIgnoreCase(termo, termo);
    }

    public List<Produto> filtrarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }

    public boolean estoqueInsuficiente(Long produtoId, int quantidade) {
        Produto produto = buscarPorId(produtoId);
        return produto.getQuantidadeEstoque() < quantidade;
    }
}
