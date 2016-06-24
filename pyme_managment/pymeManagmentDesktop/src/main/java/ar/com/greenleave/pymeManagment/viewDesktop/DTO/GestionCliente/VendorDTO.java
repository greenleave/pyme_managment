package ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente;


public class VendorDTO {
	private Long id;
	
	private PersonDTO person;
	
	private TypeOfClientDTO typeOfClient;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public TypeOfClientDTO getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(TypeOfClientDTO typeOfClient) {
		this.typeOfClient = typeOfClient;
	}
	
}
