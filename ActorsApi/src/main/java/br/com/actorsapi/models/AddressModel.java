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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.actorsapi.enums.TypeAddressEnum;

@Entity
@Table(name = "address")
public class AddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "address_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "cep", nullable = false)
	@NotNull(message = "error - cep is not null")
	private int cep;

	@Column(name = "address", length = 50, nullable = false)
	@Length(max = 50, message = "error - address max length is {max}")
	private String address;

	@Column(name = "number", length = 10, nullable = false)
	@Length(max = 10, message = "error - number max length is {max}")
	@NotNull(message = "error - number is not null")
	@NotBlank(message = "error - number is not blank")
	private String number; // numero

	@Column(name = "complement", length = 20)
	@Length(max = 20, message = "error - complement max length is {max}")
	private String complement; // complemento

	@Column(name = "type", nullable = false)
	@NotNull(message = "error - type is not null")
	@Enumerated(EnumType.STRING)
	private TypeAddressEnum type; // tipo de endereco

	@OneToOne
	@JoinColumn(name = "district_id", nullable = false)
	private DistrictModel district; // bairro

	@OneToOne
	@JoinColumn(name = "city_id", nullable = false)
	private CityModel city; // cidade e estado

	@ManyToOne
	@JoinColumn(name = "actor_id", nullable = false)
	@JsonIgnore
	private ActorModel actor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DistrictModel getDistrict() {
		return district;
	}

	public void setDistrict(DistrictModel district) {
		this.district = district;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public TypeAddressEnum getType() {
		return type;
	}

	public void setType(TypeAddressEnum type) {
		this.type = type;
	}

	public ActorModel getActor() {
		return actor;
	}

	public void setActor(ActorModel actor) {
		this.actor = actor;
	}

}
