package br.com.innerjoin.testes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.innerjoin.testes.models.TelModel;

public interface TelRepository extends JpaRepository<TelModel, Long>{
	
	
@Query("select t from TelModel t "
			+ " inner join  t.pessoa p "
			+ "where p.id = ?1")
	List<TelModel> findByPersonId(long id);
}
