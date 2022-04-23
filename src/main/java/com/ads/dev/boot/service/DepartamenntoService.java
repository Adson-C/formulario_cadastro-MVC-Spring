package com.ads.dev.boot.service;

import java.util.List;

import com.ads.dev.boot.domain.Departamento;

public interface DepartamenntoService {
	
void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();


}
