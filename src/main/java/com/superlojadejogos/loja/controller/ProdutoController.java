package com.superlojadejogos.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superlojadejogos.loja.model.Produto;
import com.superlojadejogos.loja.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Produto>> GetByTitle(@PathVariable String title){
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto product) {
		return ResponseEntity.ok(repository.save(product));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
