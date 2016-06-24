package ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente;

import java.util.List;

public class PersonDTO {
	private Long id;

	private String Name;

	private TypeOfDocumentDTO typeOfDocument;

	private String document;

	private TypeOfPerson typeOfPerson;

	private List<AdressDTO> adress;

	private List<PhoneDTO> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public TypeOfDocumentDTO getTypeOfDocument() {
		return typeOfDocument;
	}

	public void setTypeOfDocument(TypeOfDocumentDTO typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public TypeOfPerson getTypeOfPerson() {
		return typeOfPerson;
	}

	public void setTypeOfPerson(TypeOfPerson typeOfPerson) {
		this.typeOfPerson = typeOfPerson;
	}

	public List<AdressDTO> getAdress() {
		return adress;
	}

	public void setAdress(List<AdressDTO> adress) {
		this.adress = adress;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}
