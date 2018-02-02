package br.com.actorsapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.couchbase.core.mapping.event.AuditingEventListener;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company")
@EntityListeners(AuditingEventListener.class)
public class CompanyModel extends ActorModel {

	private static final long serialVersionUID = 1L;

	@Column(name = "company_identifier", length = 20, unique = true)
	@Length(max = 20, message = "error - name company identifier max length is {max}")
	private String companyIdentifier;

	@Column(name = "website", length = 50, unique = true)
	@Length(max = 50, message = "error - name website max length is {max}")
	private String website;

	@Column(name = "email_administrator", length = 50, unique = true)
	@Length(max = 50, message = "error - name email administrator max length is {max}")
	private String emailAdministrator;

	@OneToOne(mappedBy = "company")
	@JsonIgnore
	private EmployeeModel employee;

	public String getCompanyIdentifier() {
		return companyIdentifier;
	}

	public void setCompanyIdentifier(String companyIdentifier) {
		this.companyIdentifier = companyIdentifier;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmailAdministrator() {
		return emailAdministrator;
	}

	public void setEmailAdministrator(String emailAdministrator) {
		this.emailAdministrator = emailAdministrator;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

}
