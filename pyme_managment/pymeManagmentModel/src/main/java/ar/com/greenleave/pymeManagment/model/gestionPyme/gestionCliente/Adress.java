package ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PM_ADRESS")
public class Adress {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="NUM")
	private Long number;
	
	@Column(name="APARTMENT")
	private String apartment;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_ADRESS")
	private TypeOfAdress typeAdress;
	
	@Column (name="POST_CODE")
	private String postCode;
	
	@ManyToOne
	@JoinColumn(name="ID_COUNTRY")
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public TypeOfAdress getTypeAdress() {
		return typeAdress;
	}

	public void setTypeAdress(TypeOfAdress typeAdress) {
		this.typeAdress = typeAdress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
