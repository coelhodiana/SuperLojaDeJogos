package com.superlojadejogos.loja.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_category")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int code;
	
	@NotNull
	private String genre;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("category")
	private List<Produto> product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Produto> getProduct() {
		return product;
	}

	public void setProduct(List<Produto> product) {
		this.product = product;
	}
	
}
