package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PM_PERSON")

public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String Name;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_DOCUMENT")
	private TypeOfDocument typeOfDocument;
	
	@Column(name="DOCUMENT")
	private String document;
	
	@Column(name="TYPE_PERSON")
	@Enumerated(EnumType.STRING)
	private TypeOfPerson typeOfPerson;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PERSON")
	private List<Adress> adress;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	@JoinColumn(name="ID_PERSON")
	private List<Phone> phones;


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


	public TypeOfDocument getTypeOfDocument() {
		return typeOfDocument;
	}


	public void setTypeOfDocument(TypeOfDocument typeOfDocument) {
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


	public List<Adress> getAdress() {
		return adress;
	}


	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}


	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
}
