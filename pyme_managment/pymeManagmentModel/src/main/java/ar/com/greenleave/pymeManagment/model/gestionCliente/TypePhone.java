package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PM_TYPE_PHONE")
public class TypePhone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7953352339275979650L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String typePhone;

	/**
	 * 
	 * Comienzo del bloque para los getters and setters
	 * 
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypePhone() {
		return typePhone;
	}

	public void setTypePhone(String typePhone) {
		this.typePhone = typePhone;
	}

	
}
