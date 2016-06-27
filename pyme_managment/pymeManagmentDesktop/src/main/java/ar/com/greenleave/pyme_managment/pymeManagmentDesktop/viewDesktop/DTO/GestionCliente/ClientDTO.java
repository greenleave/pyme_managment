package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.GestionCliente;



public class ClientDTO {

	private Long id;
	private TypeOfClientDTO typeOfClient;
	private PersonDTO person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeOfClientDTO getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(TypeOfClientDTO typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

}
