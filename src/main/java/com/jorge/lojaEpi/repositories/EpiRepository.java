package com.jorge.lojaEpi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jorge.lojaEpi.domain.Epi;


@Repository
public interface EpiRepository extends JpaRepository<Epi, Integer> {

	@Query("SELECT obj FROM Epi obj WHERE obj.categoria.id = :id_cat ORDER BY produto")
	List<Epi> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}
