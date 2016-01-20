package ar.com.greenleave.pymeManagment.gestionCliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TYPE_ADRESS")
public class TypeAdress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String typeAdress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeAdress() {
		return typeAdress;
	}
	public void setTypeAdress(String typeAdress) {
		this.typeAdress = typeAdress;
	}
	
	
	
}
