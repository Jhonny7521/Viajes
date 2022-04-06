package com.codingdojo.jhonny.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.jhonny.modelos.Gasto;

@Repository//indico que es un repositorio
public interface RepositorioViajes extends CrudRepository<Gasto, Long> {
	
	List<Gasto> findAll();
	List<Gasto> findById(long id);

	Gasto save(Gasto gasto);
	
	void deleteById(Long id);

}
