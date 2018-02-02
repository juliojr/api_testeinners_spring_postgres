package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.actorsapi.models.StateModel;

public interface StateRepository extends JpaRepository<StateModel, Long>{
	
	@Query("select u from StateModel u where u.initials = ?1")
	StateModel findByInitials(String initials);
}
