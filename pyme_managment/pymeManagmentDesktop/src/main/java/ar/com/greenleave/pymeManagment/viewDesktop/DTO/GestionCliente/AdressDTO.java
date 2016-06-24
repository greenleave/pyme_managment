package ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente;

public class AdressDTO {

	private Long id;
	private String street;
	private Long number;
	private String apartment;
	private TypeOfAdressDTO typeAdress;
	private String postCode;
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

	public TypeOfAdressDTO getTypeAdress() {
		return typeAdress;
	}

	public void setTypeAdress(TypeOfAdressDTO typeAdress) {
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
