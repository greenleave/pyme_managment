package ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PM_TYPE_EMPLOYEE")
public class TypeOfEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String nombre;
	@Column(name = "DESCRIPTION")
	private String descripcionDelRol;
	@Column(name = "BASIC_SALARY")
	private Double sueldoBasico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionDelRol() {
		return descripcionDelRol;
	}

	public void setDescripcionDelRol(String descripcionDelRol) {
		this.descripcionDelRol = descripcionDelRol;
	}

	public Double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(Double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
}
