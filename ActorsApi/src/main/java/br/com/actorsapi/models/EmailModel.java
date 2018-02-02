package br.com.actorsapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "email")
public class EmailModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;

	@Id
	@Column(name = "email_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "email_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "email", length = 70, nullable = false)
	@Length(max = 70, message = "error - email max length is {max}")
	@NotNull(message = "error - email is not null")
	@NotBlank(message = "error - email is not blank")
	@Email(message = "error - email is not valid")
	private String email;

	@Column(name = "note", length = 100)
	@Length(max = 100, message = "error - note max length is {max}")
	private String note;

	@Column(name = "principal", columnDefinition = "boolean default false")
	private boolean principal = false;

	@ManyToOne
	@JoinColumn(name = "actor_id")
	@JsonIgnore
	private ActorModel actor;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	@JsonIgnore
	private ContactModel contact;

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public ActorModel getActor() {
		return actor;
	}

	public void setActor(ActorModel actor) {
		this.actor = actor;
	}

	public ContactModel getContact() {
		return contact;
	}

	public void setContact(ContactModel contact) {
		this.contact = contact;
	}

}
