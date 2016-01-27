package ar.com.greenleave.pymeManagment.model.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PM_COUNTRY")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Column(name = "TELEPHONE_CODE")
	private String codPhone;

	// @OneToMany(mappedBy = "country", fetch=FetchType.LAZY)
	// private List<TypeOfDocument> typeDocuments;

	/**
	 * 
	 * GETTERS AND SETTERS
	 * 
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodPhone() {
		return codPhone;
	}

	public void setCodPhone(String codPhone) {
		this.codPhone = codPhone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	// public List<TypeOfDocument> getTypeDocuments() {
	// return typeDocuments;
	// }
	//
	// public void setTypeDocuments(List<TypeOfDocument> typeDocuments) {
	// this.typeDocuments = typeDocuments;
	// }
}
