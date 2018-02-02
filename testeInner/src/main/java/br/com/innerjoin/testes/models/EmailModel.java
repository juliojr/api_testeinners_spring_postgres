package br.com.innerjoin.testes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "email_tb")
public class EmailModel {
	
	@Id
	@Column(name = "email_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "emailtb_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;
	
	@Column(name = "email", length = 50, nullable = false)
	@Length(max = 50, message = "error - address max length is {max}")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	@JsonIgnore
	private PersonModel pessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PersonModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PersonModel pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
