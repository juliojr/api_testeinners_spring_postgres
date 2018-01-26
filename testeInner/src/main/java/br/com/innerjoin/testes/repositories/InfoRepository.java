package br.com.innerjoin.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.innerjoin.testes.models.InfoModel;

public interface InfoRepository extends JpaRepository<InfoModel, Long>{

}
