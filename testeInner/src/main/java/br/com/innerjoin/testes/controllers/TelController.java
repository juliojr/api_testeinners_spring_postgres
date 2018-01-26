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

import br.com.innerjoin.testes.models.PersonModel;
import br.com.innerjoin.testes.models.TelModel;
import br.com.innerjoin.testes.models.TipoTelModel;
import br.com.innerjoin.testes.repositories.PersonRepository;
import br.com.innerjoin.testes.repositories.TelRepository;
import br.com.innerjoin.testes.repositories.TipoTelRepository;

@RestController
@RequestMapping("/tel")
public class TelController {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	TelRepository telRepository;
	@Autowired
	TipoTelRepository tipoTelRepository;

	@GetMapping("/{pId}")
	public List<TelModel> getAllByPerson(@PathVariable("pId") long id) {
		
		PersonModel p = personRepository.findOne(id);
		List<TelModel> l = p.getTelefones();
		
		return l;
	}

	@PostMapping("/{pId}")
	public TelModel create(@Valid @RequestBody TelModel tel, @PathVariable("pId") long id) {

		PersonModel p = personRepository.findOne(id);
		p.getTelefones().add(tel);
		tel.setPessoa(p);
		TipoTelModel tt = tipoTelRepository.findByNome(tel.getTipoTel().getNome());
		if (tt != null) {
			tel.setTipoTel(tt);
		} else {
			tipoTelRepository.save(tel.getTipoTel());
		}
		return telRepository.save(tel);

	}
}
