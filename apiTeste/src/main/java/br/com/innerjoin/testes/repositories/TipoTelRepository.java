package br.com.innerjoin.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.innerjoin.testes.models.TipoTelModel;

public interface TipoTelRepository extends JpaRepository<TipoTelModel, Long> {

	@Query("select tt from TipoTelModel tt  where tt.nome = ?1")
	TipoTelModel findByNome(String nome);
	
}
