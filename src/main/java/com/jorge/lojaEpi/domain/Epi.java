package com.jorge.lojaEpi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Epi implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo PRODUTO é requerido")
	@Length(min = 3, max = 50, message = "O campo PRODUTO deve ter entre 3 e 50 caracteres")
	private String produto;
	
	@NotEmpty(message = "Campo marca_produdo é requerido")
	@Length(min = 2, max = 40, message = "O campo marca_produto deve ter entre 2 e 40 caracteres")
	private String marca_produto;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requerido")
	@Length(min = 10, max = 2000000, message = "O campo DESCRIÇÃO deve ter entre 10 e 2.000.000 caracteres")
	private String descricao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Epi() {
		super();
	}

	public Epi(Integer id, String produto, String marca_produto, String descricao, Categoria categoria) {
		super();

		this.id = id;
		this.produto = produto;
		this.marca_produto = marca_produto;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getmarca_produto() {
		return marca_produto;
	}

	public void setmarca_produto(String marca_produto) {
		this.marca_produto = marca_produto;
	}

	public String getdescricao() {
		return descricao;
	}

	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epi other = (Epi) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
