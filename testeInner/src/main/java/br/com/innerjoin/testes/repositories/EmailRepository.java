package br.com.innerjoin.testes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.innerjoin.testes.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{

	
	@Query("select e from EmailModel e "
			+ " inner join  e.pessoa p "
			+ "where p.id = ?1")
	List<EmailModel> findByPersonId(long id);
	
}
