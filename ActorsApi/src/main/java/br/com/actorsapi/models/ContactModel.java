package br.com.actorsapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contact")
public class ContactModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contact_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "contact_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private int id;

	@Column(name = "name", length = 30, nullable = false, unique = true)
	@Length(max = 30, message = "error - name max length is {max}")
	@NotNull(message = "error - name is not null")
	@NotBlank(message = "error - name is not blank")
	private String name; // nome

	@Column(name = "note", length = 100)
	@Length(max = 100, message = "error - note max length is {max}")
	private String note;// observação

	@OneToMany(mappedBy = "contact")
	@JsonIgnore
	private List<EmailModel> emails = new ArrayList<>(); // emails

	@OneToMany(mappedBy = "contact")
	@JsonIgnore
	private List<PhoneModel> phones = new ArrayList<>(); // telefones

	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false)
	@JsonIgnore
	private ProviderModel provider;

	public void addEmail(EmailModel pEmail) {
		pEmail.setContact(this);
		this.emails.add(pEmail);
	}

	public void removeEmail(int index) {
		this.emails.remove(index);
	}

	public void addPhone(PhoneModel pPhone) {
		pPhone.setContact(this);
		this.phones.add(pPhone);
	}

	public void removePhone(int index) {
		this.phones.remove(index);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmailModel> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailModel> emails) {
		this.emails = emails;
	}

	public List<PhoneModel> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneModel> phones) {
		this.phones = phones;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ProviderModel getProvider() {
		return provider;
	}

	public void setProvider(ProviderModel provider) {
		this.provider = provider;
	}

}
