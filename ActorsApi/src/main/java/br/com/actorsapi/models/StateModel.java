package br.com.actorsapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "state")
public class StateModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "state_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "state_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "name", length = 50)
	@Length(max = 75, message = "error - name max length is {max}")
	private String name; // estado

	@Column(name = "initials", length = 2, nullable = false, unique = true)
	@Length(max = 2, message = "error - initials max length is {max}")
	@NotNull(message = "error - initials is not null")
	@NotBlank(message = "error - initials is not blank")
	private String initials;// sigla

	@OneToOne(mappedBy = "state")
	@JsonIgnore
	private CityModel city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

}
