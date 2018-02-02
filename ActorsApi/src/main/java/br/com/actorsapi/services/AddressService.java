package br.com.actorsapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.actorsapi.models.AddressModel;
import br.com.actorsapi.models.CityModel;
import br.com.actorsapi.models.DistrictModel;
import br.com.actorsapi.models.StateModel;
import br.com.actorsapi.repositories.ActorRepository;
import br.com.actorsapi.repositories.AddressRepository;
import br.com.actorsapi.repositories.CityRepository;
import br.com.actorsapi.repositories.DistrictRepository;
import br.com.actorsapi.repositories.StateRepository;
import br.com.actorsapi.util.Util;
import br.com.actorsapi.util.ViaCep;
import br.com.actorsapi.util.ViaCepWS;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	StateRepository stateRepository;
	@Autowired
	ActorRepository actorRepository;
	
	public List<AddressModel> getAllAddressesByActorId(long actorId){
		
		List<AddressModel> addresses = addressRepository.findByActorId(actorId);
		return addresses;
	}
	
	public AddressModel saveAddress(AddressModel address, long id) {

		String cep = Integer.toString(address.getCep());
		
		address.setActor(actorRepository.findOne(id));
		
		if (address.getActor() != null) {
			if (Util.validaCep(cep)) {
				ViaCep viaCep = ViaCepWS.searchCep(cep);
				if (viaCep != null) {
					address.setCep(Integer.parseInt(viaCep.getCep().replace("-", "")));
					address.setAddress(viaCep.getLogradouro());
					DistrictModel district = districtRepository.findByName(viaCep.getBairro());
					if (district == null) {
						district = new DistrictModel();
						district.setName(viaCep.getBairro());
						district = districtRepository.save(district);
					}
					address.setDistrict(district);

					StateModel state = stateRepository.findByInitials(viaCep.getUf());
					if (state == null) {
						state = new StateModel();
						state.setInitials(viaCep.getUf());
						state = stateRepository.save(state);
					}

					CityModel city = cityRepository.findByName(viaCep.getLocalidade());
					if (city == null) {
						city = new CityModel();
						city.setState(state);
						city.setName(viaCep.getLocalidade());
						city = cityRepository.save(city);
					}

					address.setCity(city);

					address = addressRepository.save(address);

				} else {
					return null;
				}
			}
		}else {
			return null;
		}
		return address;
	}

}
