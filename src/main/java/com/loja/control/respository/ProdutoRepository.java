package com.loja.control.respository;

import com.loja.control.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCaseOrCodigoContainingIgnoreCase(String nome, String codigo);
    List<Produto> findByCategoriaId(Long categoriaId);
}
