package com.superlojadejogos.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superlojadejogos.loja.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByTitleContainingIgnoreCase(String title);
}
