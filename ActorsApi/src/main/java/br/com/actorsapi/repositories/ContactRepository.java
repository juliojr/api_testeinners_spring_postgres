package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long>{

}
