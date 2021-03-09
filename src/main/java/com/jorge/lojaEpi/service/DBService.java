package com.jorge.lojaEpi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.lojaEpi.domain.Categoria;
import com.jorge.lojaEpi.domain.Epi;
import com.jorge.lojaEpi.repositories.CategoriaRepository;
import com.jorge.lojaEpi.repositories.EpiRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;   //camada de acesso a os dados 
	@Autowired
	private EpiRepository epiRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Bota", "Calçados Diversos");
		Categoria cat2 = new Categoria(null, "Luva", "Luvas Diversas");
		Categoria cat3 = new Categoria(null, "Mascara", "Mascaras Diversas");
		
		Epi e1 = new Epi(null, "Bota Cadarço", "Bracol", "Bota de cadarço com solado anti derrapante", cat1);
		Epi e2 = new Epi(null, "Luva Resinada", "Previflex", "Luva de malha resinada", cat2);
		Epi e3 = new Epi(null, "Luva Pigmentada", "flex", "Luva de malha pigmentada", cat2);
		Epi e4 = new Epi(null, "Mascara Cirurgica", "Descarbox", "Mascara com 3 camadas de proteção", cat3);
		Epi e5 = new Epi(null, "Respirado Valvulado", "3M", "Respirador com valvula", cat3);
		
		cat1.getEpis().addAll(Arrays.asList(e1, e2)); 
		cat1.getEpis().addAll(Arrays.asList(e3, e4, e5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.epiRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
	}

}
