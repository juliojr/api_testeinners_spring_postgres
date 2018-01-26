package br.com.innerjoin.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.innerjoin.testes.models.PersonModel;


public interface PersonRepository extends JpaRepository<PersonModel, Long> {

}
