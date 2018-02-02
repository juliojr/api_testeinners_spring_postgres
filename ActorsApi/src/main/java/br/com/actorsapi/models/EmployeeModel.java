package br.com.actorsapi.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.actorsapi.enums.FunctionEnum;

@Entity
@Table(name = "employee")
public class EmployeeModel extends ActorModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "doc_rg", length = 11, nullable = false)
	@Length(max = 11, message = "error - RG max length is {max}")
	private String docRG;

	@Column(name = "function", nullable = false)
	@NotNull(message = "error - function is not null")
	@Enumerated(EnumType.STRING)
	private FunctionEnum function;

	@Column(name = "date_admission")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateAdmission;

	@Column(name = "date_demission")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateDemission;

	@OneToOne
	@JoinColumn(name = "company_id", nullable = false)
	private CompanyModel company;

	public String getDocRG() {
		return docRG;
	}

	public void setDocRG(String docRG) {
		this.docRG = docRG;
	}

	public FunctionEnum getFunction() {
		return function;
	}

	public void setFunction(FunctionEnum function) {
		this.function = function;
	}

	public Calendar getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(Calendar dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	public Calendar getDateDemission() {
		return dateDemission;
	}

	public void setDateDemission(Calendar dateDemission) {
		this.dateDemission = dateDemission;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

}
