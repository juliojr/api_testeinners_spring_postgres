package br.com.actorsapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "actor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ActorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "actor_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "actor_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private Long id;

	@Column(name = "date_register", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "error - date register is not null")
	private Calendar dateRegister = Calendar.getInstance(); // data cadastro

	@Column(name = "name", length = 70, nullable = false)
	@Length(max = 70, message = "error - name max length is {max}")
	@NotNull(message = "error - name is not null")
	@NotBlank(message = "error - name is not blank")
	private String name; // nome ou razão social

	@Column(name = "nickname", length = 40)
	@Length(max = 40, message = "error - nickname max length is {max}")
	private String nickname; // apelido ou fantasia

	@Column(name = "status", columnDefinition = "boolean default true")
	private Boolean status = true; // situacao Ativo/Inativo

	@Column(name = "note", length = 150)
	@Length(max = 150, message = "error - note max length is {max}")
	private String note; // observação

	@Column(name = "doc_identifier", unique = true)
	@CPF // @CNPJ
	private String docIdentifier; // cpf / cnpj

	@OneToMany(mappedBy = "actor")
	private List<EmailModel> emails = new ArrayList<>(); // emails

	@OneToMany(mappedBy = "actor", fetch=FetchType.EAGER)
	private List<AddressModel> addresses = new ArrayList<>(); // endereços

	@OneToMany(mappedBy = "actor")
	@JsonIgnore
	private List<PhoneModel> phones = new ArrayList<>(); // telefones

	public void addAddress(AddressModel pAddress) {
		pAddress.setActor(this);
		this.addresses.add(pAddress);
	}

	public void removeAddress(int index) {
		this.addresses.remove(index);
	}

	public void addPhone(PhoneModel pPhone) {
		pPhone.setActor(this);
		this.phones.add(pPhone);
	}

	public void removePhone(int index) {
		this.phones.remove(index);
	}

	public void addEmail(EmailModel pEmail) {
		pEmail.setActor(this);
		this.emails.add(pEmail);
	}

	public void removeEmail(int index) {
		this.emails.remove(index);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDocIdentifier() {
		return docIdentifier;
	}

	public void setDocIdentifier(String docIdentifier) {
		this.docIdentifier = docIdentifier;
	}

	public List<EmailModel> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailModel> emails) {
		this.emails = emails;
	}

	public List<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressModel> addresses) {
		this.addresses = addresses;
	}

	public List<PhoneModel> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneModel> phones) {
		this.phones = phones;
	}

}
