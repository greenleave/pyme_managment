package ar.com.greenleave.pymeManagment.gestionCliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PM_TYPE_DOCUMENT")
public class TypeDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String typeDocument;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_COUNTRY")
	private Country country;

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

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
