package br.com.actorsapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.actorsapi.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

	@Query("select e from EmailModel e "
			+ "inner join e.actor a"
			+ " where a.id = ?1")
	List<EmailModel> findByActorId(long id);

}
