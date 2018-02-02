package br.com.innerjoin.testes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.innerjoin.testes.models.EmailModel;
import br.com.innerjoin.testes.models.PersonModel;
import br.com.innerjoin.testes.repositories.EmailRepository;
import br.com.innerjoin.testes.repositories.PersonRepository;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/{pId}")
	public List<EmailModel> getAllByPerson(@PathVariable("pId") long id) {
		 
		return emailRepository.findByPersonId(id);
	}
	
	@PostMapping("/{pId}")
	public EmailModel create(@Valid @RequestBody EmailModel email, @PathVariable("pId") long id) {
		
		PersonModel p = personRepository.findOne(id);
		p.getEmails().add(email);
		email.setPessoa(p);
		
		return emailRepository.save(email);
	}
}
