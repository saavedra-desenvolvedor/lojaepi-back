package com.jorge.lojaEpi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.lojaEpi.domain.Categoria;
import com.jorge.lojaEpi.domain.Epi;
import com.jorge.lojaEpi.repositories.EpiRepository;
import com.jorge.lojaEpi.service.exception.ObjectNotFoundException;

@Service
public class EpiService {

	@Autowired
	private EpiRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Epi findByid(Integer id) {
		Optional<Epi> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não Encontrado id: " + id + ", Tipo: " + Epi.class.getName()));   
		
	}

	public List<Epi> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Epi udate(Integer id, Epi obj) {
		Epi newObj = findByid(id);
		updateDate(newObj, obj);
		return repository.save(newObj);
	}

	private void updateDate(Epi newObj, Epi obj) {
		newObj.setProduto(obj.getProduto());
		newObj.setmarca_produto(obj.getmarca_produto());
		newObj.setdescricao(obj.getdescricao());		
	}

	public Epi create(Integer id_cat, @Valid Epi obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Epi obj = findByid(id);
		repository.delete(obj);
	}
}
