package com.ads.dev.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ads.dev.boot.dao.DepartamentoDao;
import com.ads.dev.boot.domain.Departamento;


@Service 
public class DepartamentoServiceImpl implements DepartamenntoService {
	
	@Autowired
	private DepartamentoDao departamentoDao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Departamento departamento) {
		departamentoDao.save(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Departamento departamento) {
		departamentoDao.update(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		departamentoDao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		
		return departamentoDao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		
		return departamentoDao.findAll();
	}

}
