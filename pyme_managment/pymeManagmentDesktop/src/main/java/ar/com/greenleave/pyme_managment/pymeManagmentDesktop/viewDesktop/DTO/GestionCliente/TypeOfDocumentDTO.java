package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.GestionCliente;


public class TypeOfDocumentDTO {

	private Long id;
	private String typeDocument;

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
