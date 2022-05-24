package com.ads.dev.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ads.dev.boot.domain.Cargo;
import com.ads.dev.boot.util.PaginacaoUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
	
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina) {
		
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho;  // 0*5=0 , 1*5=5 , 2*5=10
		
		List<Cargo> cargos = getEntityManager()
				.createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistro = count();
		long totalDePaginas = (totalRegistro + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<Cargo>(tamanho, pagina, totalDePaginas, cargos);
	}
	
	public long count() {
		return getEntityManager()
				.createNamedQuery("select count(*) from Cargo", Long.class)
				.getSingleResult();
	}

}
