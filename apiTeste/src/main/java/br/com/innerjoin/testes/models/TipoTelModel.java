package br.com.innerjoin.testes.models;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo_tel")
public class TipoTelModel {
	@Id
	@Column(name = "tipo_tel_id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "tipo_tel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private int id;

	@Column(name = "nome", length = 50, nullable = false)
	@Length(max = 50, message = "error - address max length is {max}")
	@NotNull(message = "error - address is not null")
	private String nome;

	@OneToOne(mappedBy = "tipoTel")
	@JsonIgnore
	private TelModel tel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TelModel getTel() {
		return tel;
	}

	public void setTel(TelModel tel) {
		this.tel = tel;
	}

}
