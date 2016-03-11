package ar.com.greenleave.pymeManagment.model.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PM_TYPE_VENDOR")
public class TypeOfVendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="DESCRIPTION")
	private String typeOfVendor;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeOfVendor() {
		return typeOfVendor;
	}
	public void setTypeOfVendor(String typeOfVendor) {
		this.typeOfVendor = typeOfVendor;
	}
}
