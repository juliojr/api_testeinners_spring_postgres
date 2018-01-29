package br.com.actorsapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.couchbase.core.mapping.event.AuditingEventListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "district")
@EntityListeners(AuditingEventListener.class)
public class DistrictModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "district_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "district_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "name", length = 50, nullable = false)
	@Length(max = 50, message = "error - name max length is {max}")
	@NotNull(message = "error - name is not null")
	@NotBlank(message = "error - name is not blank")
	private String name;// bairro

	@OneToOne(mappedBy = "district", fetch=FetchType.EAGER)
	@JsonIgnore
	private AddressModel address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

}
