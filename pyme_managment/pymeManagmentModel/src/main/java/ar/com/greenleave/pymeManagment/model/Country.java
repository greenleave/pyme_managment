package ar.com.greenleave.pymeManagment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PM_COUNTRY")
public class Country {

	public Country() {

		typeDocuments = new ArrayList<TypeDocument>();
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DESCRIPCION")
	private String name;

	@OneToMany(targetEntity = TypeDocument.class, mappedBy = "Country", cascade = CascadeType.ALL)
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

}
