package com.codingdojo.jhonny.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.jhonny.modelos.Gasto;
import com.codingdojo.jhonny.repositorios.RepositorioViajes;

@Service//le digo que es un servicio
public class ServicioViajes {
	
	private final RepositorioViajes repositorio;
	
	public ServicioViajes(RepositorioViajes repo) {
		this.repositorio = repo;		
	}
	
	public List<Gasto> get_gastos(){//regresa lo de findAll
		return repositorio.findAll();
	}
	
	public Gasto find_gasto(Long id){//regresa lo de findAll
		Optional<Gasto> optionalGasto = repositorio.findById(id); //para vefiricar si llega algo
		//List<Gasto> optionalGasto = repositorio.findById(id); otra opcion
		//if(optionalGasto.isEmpty()) { comparamos as@@@i
		if(optionalGasto.isPresent()) {
			return optionalGasto.get();
		}else {
			return null;
		}		
	}
	
	public Gasto save_gasto(Gasto gasto) {//si tiene id lo actualiza si no tiene id lo inserta en la BD
		return repositorio.save(gasto);
	}
	
	public void delete_gasto(Long id) {
		repositorio.deleteById(id);
	}
	

}
