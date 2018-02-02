package br.com.actorsapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.actorsapi.models.EmailModel;
import br.com.actorsapi.repositories.ActorRepository;
import br.com.actorsapi.repositories.EmailRepository;
import br.com.actorsapi.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	ActorRepository actorRepository;

	@GetMapping("/{actorId}")
	public List<EmailModel> getEmailsByActor(@PathVariable("actorId") long id) {
		List<EmailModel> emails = emailRepository.findByActorId(id);
		return emails;
	}

	@PostMapping("/{actorId}")
	public EmailModel createEmail(@Valid @RequestBody EmailModel email, @PathVariable("actorId") long id) {

		email.setActor(actorRepository.findOne(id));
		email = emailRepository.save(email);
		return email;
	}

}
