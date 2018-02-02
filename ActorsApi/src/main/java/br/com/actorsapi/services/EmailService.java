package br.com.actorsapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.actorsapi.models.EmailModel;
import br.com.actorsapi.repositories.ActorRepository;
import br.com.actorsapi.repositories.EmailRepository;

@Service
public class EmailService {
	@Autowired
	EmailRepository emailRepository;
	@Autowired
	ActorRepository actorRepository;
	
	public EmailModel saveEmail(EmailModel email, long  id) {
		
		email = emailRepository.save(email);
		return email;
		
	}
	
}
