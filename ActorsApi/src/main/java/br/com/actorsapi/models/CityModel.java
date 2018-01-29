package br.com.actorsapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class CityModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "city_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "city_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private Long id;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	@Length(max = 50, message = "error - name max length is {max}")
	@NotNull(message = "error - name is not null")
	@NotBlank(message = "error - name is not blank")
	private String name; // cidade

	@OneToOne
	@JoinColumn(name = "state_id")
	private StateModel state; // estado

	@OneToOne(mappedBy = "city", fetch=FetchType.EAGER)
	@JsonIgnore
	private AddressModel address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateModel getState() {
		return state;
	}

	public void setState(StateModel state) {
		this.state = state;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

}
