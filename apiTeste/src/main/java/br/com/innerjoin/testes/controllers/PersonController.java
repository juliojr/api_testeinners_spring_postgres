package br.com.innerjoin.testes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.innerjoin.testes.models.PersonModel;
import br.com.innerjoin.testes.repositories.InfoRepository;
import br.com.innerjoin.testes.repositories.PersonRepository;

@RestController
@RequestMapping("/pessoa")
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	InfoRepository infoRepository;
	
	@GetMapping
	public List<PersonModel> getAll() {
		 
		return (List<PersonModel>) personRepository.findAll();
	}
	
	@PostMapping
	public PersonModel create(@Valid @RequestBody PersonModel pessoa) {
		
		pessoa.setInfo(infoRepository.save(pessoa.getInfo()));
		
		return personRepository.save(pessoa);
	}
	
}
