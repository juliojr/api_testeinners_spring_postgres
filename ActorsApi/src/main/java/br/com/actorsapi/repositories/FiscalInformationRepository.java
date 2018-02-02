package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.FiscalInformationModel;

public interface FiscalInformationRepository extends JpaRepository<FiscalInformationModel, Long> {

}
