package ar.com.greenleave.pymeManagment.model.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PM_CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_CLIENT")
	private TypeOfClient typeOfClient;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERSON")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeOfClient getTypeOfClient() {
		return typeOfClient;
	}

	public void setTypeOfClient(TypeOfClient typeOfClient) {
		this.typeOfClient = typeOfClient;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
