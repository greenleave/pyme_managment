package ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PM_TYPE_CLIENT")
public class TypeOfClient {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="DESCRIPTION")
	private String typeOfClient;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeOfClient() {
		return typeOfClient;
	}
	public void setTypeOfClient(String typeOfClient) {
		this.typeOfClient = typeOfClient;
	}
	
	
	
	
}
