package br.com.actorsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.actorsapi.repositories.ActorRepository;
import br.com.actorsapi.repositories.AddressRepository;
import br.com.actorsapi.repositories.CityRepository;
import br.com.actorsapi.repositories.CompanyRepository;
import br.com.actorsapi.repositories.ContactRepository;
import br.com.actorsapi.repositories.CustomerRepository;
import br.com.actorsapi.repositories.DistrictRepository;
import br.com.actorsapi.repositories.EmailRepository;
import br.com.actorsapi.repositories.EmployeeRepository;
import br.com.actorsapi.repositories.FiscalInformationRepository;
import br.com.actorsapi.repositories.PhoneRepository;
import br.com.actorsapi.repositories.ProviderRepository;
import br.com.actorsapi.repositories.StateRepository;

@SpringBootApplication(scanBasePackages= "br.com.actorsapi")
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class, ActorRepository.class, AddressRepository.class, CityRepository.class, 
		CompanyRepository.class, ContactRepository.class, DistrictRepository.class, EmailRepository.class, EmployeeRepository.class, FiscalInformationRepository.class,
		PhoneRepository.class, ProviderRepository.class, StateRepository.class})
public class ActorsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActorsApiApplication.class, args);
	}
}
