package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PM_PERSON")

public class Person {
	@Id
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
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PM_PERSON_ADRESS", 
	joinColumns=
		{@JoinColumn(name="ID_PERSONA", nullable=false,updatable=false)}
	,inverseJoinColumns=
		{@JoinColumn(name="ID_DIRECCION", nullable=false, updatable=false)}
	)
	private List<Adress> adress;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PM_PERSON_PHONE", 
	joinColumns=
		{@JoinColumn(name="ID_PERSONA", nullable=false,updatable=false)}
	,inverseJoinColumns=
		{@JoinColumn(name="ID_TELEFONO", nullable=false, updatable=false)}
	)
	
	private List<Phone> phones;
	
	
}
