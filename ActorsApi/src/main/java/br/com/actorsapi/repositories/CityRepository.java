package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.actorsapi.models.CityModel;

public interface CityRepository  extends JpaRepository<CityModel, Long>{

	
	@Query("select u from CityModel u where u.name = ?1")
	CityModel findByName(String name);
}
