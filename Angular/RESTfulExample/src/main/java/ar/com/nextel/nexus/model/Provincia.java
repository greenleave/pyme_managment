package ar.com.nextel.nexus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia implements Serializable{
	
	public int id;
	public String provincia;

	@Id
	@Column(name="id", unique=false, nullable=false)
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	@Column(name="provincia", unique=false, nullable=false)
	public String getProvincia() {
		return this.provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}	
}
