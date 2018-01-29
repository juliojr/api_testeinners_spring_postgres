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

import org.hibernate.validator.constraints.Length;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fiscal_info")
public class FiscalInformationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fiscal_info_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "fiscalinfo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "state_reg", length = 100)
	@Length(max = 100, message = "error - state registration max length is {max}")
	private String stateRegistration;

	@Column(name = "municipal_reg", length = 100)
	@Length(max = 100, message = "error - municipal registration max length is {max}")
	private String municipalRegistration;

	@Column(name = "suframa", length = 100)
	@Length(max = 100, message = "error - suframa max length is {max}")
	private String suframa;

	@Column(name = "taxpayer_icms", columnDefinition = "boolean default false")
	private boolean taxpayerICMS;

	@OneToOne(mappedBy = "fiscalInformations")
	@JsonIgnore
	private CustomerModel customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStateRegistration() {
		return stateRegistration;
	}

	public void setStateRegistration(String stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	public String getMunicipalRegistration() {
		return municipalRegistration;
	}

	public void setMunicipalRegistration(String municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	public String getSuframa() {
		return suframa;
	}

	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}

	public boolean isTaxpayerICMS() {
		return taxpayerICMS;
	}

	public void setTaxpayerICMS(boolean taxpayerICMS) {
		this.taxpayerICMS = taxpayerICMS;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

}
