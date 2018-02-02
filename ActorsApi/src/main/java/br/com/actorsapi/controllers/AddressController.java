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

import br.com.actorsapi.models.AddressModel;
import br.com.actorsapi.repositories.AddressRepository;
import br.com.actorsapi.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	public List<AddressModel> getAllAddresses() {
		
		return (List<AddressModel>) addressRepository.findAll();
	}
	
	@GetMapping("/{actorId}")
	public List<AddressModel> getAddressesByActor(@PathVariable("actorId") long id) {
		List<AddressModel> addresses = addressService.getAllAddressesByActorId(id);
			
			return addresses;
	}
	
	@PostMapping("/{actorId}")
	public AddressModel createAddress(@Valid @RequestBody AddressModel address, @PathVariable("actorId") long actorId) {
		return addressService.saveAddress(address,actorId);
	}
}
