package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.actorsapi.models.DistrictModel;

public interface DistrictRepository extends JpaRepository<DistrictModel, Long> {
	
	@Query("select u from DistrictModel u where u.name = ?1")
	DistrictModel findByName(String name);
	
}
