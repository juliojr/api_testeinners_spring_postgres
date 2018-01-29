package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.ProviderModel;

public interface ProviderRepository extends JpaRepository<ProviderModel, Long> {
	
}
