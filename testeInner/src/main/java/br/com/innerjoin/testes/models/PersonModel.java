package br.com.innerjoin.testes.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pessoa")
public class PersonModel {

	@Id
	@Column(name = "pessoa_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "pessoa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;
	
	
	@Column(name = "nome", length = 50, nullable = false)
	@Length(max = 50, message = "error - address max length is {max}")
	@NotNull(message = "error - address is not null")
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "info_id", nullable = false)
	private InfoModel info;
	
	@OneToMany(mappedBy = "pessoa")
	private List<TelModel> telefones = new ArrayList<>();
	
	@OneToMany(mappedBy = "pessoa", fetch=FetchType.EAGER)
	private List<EmailModel> emails = new ArrayList<>();
	
	public void add(TelModel tel) {
		this.telefones.add(tel);
	}
	public void add(EmailModel email) {
		this.emails.add(email);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public InfoModel getInfo() {
		return info;
	}
	public void setInfo(InfoModel info) {
		this.info = info;
	}
	public List<TelModel> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelModel> telefones) {
		this.telefones = telefones;
	}


	public List<EmailModel> getEmails() {
		return emails;
	}


	public void setEmails(List<EmailModel> emails) {
		this.emails = emails;
	}
	
	
	

}
