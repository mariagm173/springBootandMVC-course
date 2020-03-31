package com.maria.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maria.spring.model.Empleado;

@Service("empleadoServiceMemory")
public class EmpleadoServiceMemory implements IEmpleadoService {

	private List<Empleado> repositorio = new ArrayList<>();
	
	public Empleado add(Empleado e) {
		repositorio.add(e);
		return e;
	}
	
	public List<Empleado> findAll() {
		return repositorio;
	}
	
	public Empleado findById(long id) {
		Empleado result = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < repositorio.size()) {
			if (repositorio.get(i).getId() == id) {
				encontrado = true;
				result = repositorio.get(i);
			} else {
				i++;
			}
		}
		
		return result;
	}
	
	public Empleado edit(Empleado e) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < repositorio.size()) {
			if (repositorio.get(i).getId() == e.getId()) {
				encontrado = true;
				repositorio.remove(i);
				repositorio.add(i, e);
			} else {
				i++;
			}
		}
		
		if (!encontrado)
			repositorio.add(e);
		
		return e;
	}
	
	/*
	 * @PostConstruct public void init() { repositorio.addAll( Arrays.asList(new
	 * Empleado(1,"Antonio García", "antonio.garcia@openwebinars.net", "954000000"),
	 * new Empleado(2,"María López", "maria.lopez@openwebinars.net", "954000000"),
	 * new Empleado(3,"Ángel Antúnez", "angel.antunez@openwebinars.net",
	 * "954000000"))); }
	 */

	@Override
	public List<Empleado> buscador(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}
}
