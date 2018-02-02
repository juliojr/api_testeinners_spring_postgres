package br.com.innerjoin.testes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tel")
public class TelModel {

	@Id
	@Column(name = "tel_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "tel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private long id;

	@Column(name = "numero", length = 20, nullable = false)
	@Length(max = 20, message = "error - name max length is {max}")
	@NotNull(message = "error - name is not null")
	private String numero;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	@JsonIgnore
	private PersonModel pessoa;

	@OneToOne
	@JoinColumn(name = "tipo_tel_id", nullable = false)
	private TipoTelModel tipoTel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public PersonModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PersonModel pessoa) {
		this.pessoa = pessoa;
	}

	public TipoTelModel getTipoTel() {
		return tipoTel;
	}

	public void setTipoTel(TipoTelModel tipoTel) {
		this.tipoTel = tipoTel;
	}

}
