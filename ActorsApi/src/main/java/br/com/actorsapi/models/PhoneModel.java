package br.com.actorsapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.actorsapi.enums.TypePhoneEnum;

@Entity
@Table(name = "phone")
public class PhoneModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "phone_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "phone_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "number", nullable = false)
	@NotNull(message = "error - number phone is not null")
	private long number;

	@Column(name = "note", length = 100)
	@Length(max = 100, message = "error - note max length is {max}")
	private String note;

	@Column(name = "type", nullable = false)
	@NotNull(message = "error - type is not null")
	@Enumerated(EnumType.STRING)
	private TypePhoneEnum type;

	@Column(name = "principal", columnDefinition = "boolean default false")
	private boolean principal;

	@ManyToOne
	@JoinColumn(name = "actor_id", nullable = true)
	@JsonIgnore
	private ActorModel actor;

	@ManyToOne
	@JoinColumn(name = "contact_id", nullable = true)
	@JsonIgnore
	private ContactModel contact;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public TypePhoneEnum getType() {
		return type;
	}

	public void setType(TypePhoneEnum type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "PhoneModel [id=" + id + ", number=" + number + ", note=" + note + ", type=" + type + ", principal="
				+ principal + ", actor=" + actor + ", contact=" + contact + "]";
	}

}
