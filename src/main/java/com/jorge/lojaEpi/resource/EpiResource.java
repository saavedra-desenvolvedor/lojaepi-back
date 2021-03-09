package com.jorge.lojaEpi.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jorge.lojaEpi.domain.Epi;
import com.jorge.lojaEpi.dtos.EpiDTO;
import com.jorge.lojaEpi.service.EpiService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/epis")
public class EpiResource {

	@Autowired
	private EpiService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Epi> findByid(@PathVariable Integer id) {
		Epi obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<EpiDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Epi> list = service.findAll(id_cat);
		List<EpiDTO> listDTO = list.stream().map(obj -> new EpiDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

		// localhost:8080/epis?categoria=1
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Epi> update(@PathVariable Integer id, @Valid @RequestBody Epi obj) {
		Epi newObj = service.udate(id, obj);
		return ResponseEntity.ok().body(newObj);

	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Epi> updatePatch(@PathVariable Integer id,@Valid  @RequestBody Epi obj) {
		Epi newObj = service.udate(id, obj);
		return ResponseEntity.ok().body(newObj);

	}
	
	@PostMapping
	public ResponseEntity<Epi> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Epi obj) {
		Epi newObj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/Epis/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
