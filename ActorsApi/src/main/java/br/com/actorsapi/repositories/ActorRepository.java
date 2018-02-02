package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.ActorModel;

public interface ActorRepository extends JpaRepository<ActorModel, Long> {

}
