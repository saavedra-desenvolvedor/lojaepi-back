package com.jorge.lojaEpi.dtos;

import java.io.Serializable;

import com.jorge.lojaEpi.domain.Epi;

public class EpiDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String produto;

	public EpiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EpiDTO(Epi obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
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

}
