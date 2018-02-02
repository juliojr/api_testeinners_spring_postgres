package br.com.actorsapi.models;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonBackReference;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.actorsapi.enums.GenderEnum;
import br.com.actorsapi.enums.PersonTypeEnum;

@Entity
@Table(name = "customer")
public class CustomerModel extends ActorModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "person_type", nullable = false)
	@NotNull(message = "error - type is not null")
	@Enumerated(EnumType.STRING)
	private PersonTypeEnum personType; // tipo de cliente - fisico / juridico

	@Column(name = "social_network", length = 70)
	@Length(max = 70, message = "error - social network max length is {max}")
	private String socialNetwork;// rede social instagram / facebook

	@Column(name = "date_birth", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "error - date register is not null")
	private Calendar dateBirth; // data de nascimento

	@Column(name = "gender", nullable = false)
	@NotNull(message = "error - gender is not null")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender; // sexo

	@Digits(integer = 5, fraction = 2)
	@Column(name = "addition_or_discount_perc")
	private BigDecimal defaultAdditionOrdiscountPerc = new BigDecimal("0"); // percentual de acrescimo ou desconto
																			// -(valor) desconto / +(valor) acrescimo

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "fiscal_info_id", nullable = true)
	@JsonBackReference
	@JsonIgnore
	private FiscalInformationModel fiscalInformations; // informaçoes fiscais

	public PersonTypeEnum getPersonType() {
		return personType;
	}

	public void setPersonType(PersonTypeEnum personType) {
		this.personType = personType;
	}

	public String getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	public Calendar getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Calendar dateBirth) {
		this.dateBirth = dateBirth;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public BigDecimal getDefaultAdditionOrdiscountPerc() {
		return defaultAdditionOrdiscountPerc;
	}

	public void setDefaultAdditionOrdiscountPerc(BigDecimal defaultAdditionOrdiscountPerc) {
		this.defaultAdditionOrdiscountPerc = defaultAdditionOrdiscountPerc;
	}

	public FiscalInformationModel getFiscalInformations() {
		return fiscalInformations;
	}

	public void setFiscalInformations(FiscalInformationModel fiscalInformations) {
		this.fiscalInformations = fiscalInformations;
	}

}
