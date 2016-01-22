package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PM_COUNTRY")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String name;
	
	@OneToMany(mappedBy = "country", fetch=FetchType.LAZY)
	private List<TypeDocument> typeDocuments;

	/**
	 * 
	 * GETTERS AND SETTERS
	 * 
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public List<TypeDocument> getTypeDocuments() {
		return typeDocuments;
	}

	public void setTypeDocuments(List<TypeDocument> typeDocuments) {
		this.typeDocuments = typeDocuments;
	}
}
