package br.com.actorsapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.actorsapi.enums.PersonTypeEnum;

@Entity
@Table(name = "provider")
public class ProviderModel extends ActorModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "person_type", nullable = false)
	@NotNull(message = "error - person type is not null")
	@Enumerated(EnumType.STRING)
	private PersonTypeEnum personType; // tipo de pessoa - fisico / juridico

	@Column(name = "website", length = 100)
	@Length(max = 100, message = "error - website max length is {max}")
	private String website;

	@OneToMany(mappedBy = "provider")
	private List<ContactModel> contacts = new ArrayList<>();

	public void addContact(ContactModel pContact) {
		pContact.setProvider(this);
		this.contacts.add(pContact);
	}

	public void removeContact(int index) {
		this.contacts.remove(index);
	}

	public PersonTypeEnum getPersonType() {
		return personType;
	}

	public void setPersonType(PersonTypeEnum personType) {
		this.personType = personType;
	}

	public List<ContactModel> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
