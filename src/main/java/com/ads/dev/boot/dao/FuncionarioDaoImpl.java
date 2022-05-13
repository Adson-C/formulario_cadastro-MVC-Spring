package com.ads.dev.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ads.dev.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		
		/*
		 * TypedQuery<Funcionario> query = getEntityManager()
		 * .createQuery("select f from Funcionario f where f.nome like :nome",
		 * Funcionario.class); query.setParameter("nome", nome); return
		 * query.getResultList();
		 */
		
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Funcionario> findByCargoId(Long id) {
		
		
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

}
