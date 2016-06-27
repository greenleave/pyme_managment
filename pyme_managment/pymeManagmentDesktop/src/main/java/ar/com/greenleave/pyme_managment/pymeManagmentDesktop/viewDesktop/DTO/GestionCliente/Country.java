package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.GestionCliente;



public class Country {

	private Long id;

	private String country;

	private String countryCode;

	private String codPhone;

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
