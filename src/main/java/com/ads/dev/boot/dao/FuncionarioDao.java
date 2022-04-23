package com.ads.dev.boot.dao;

import java.util.List;

import com.ads.dev.boot.domain.Funcionario;

public interface FuncionarioDao {
	
void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();

}
