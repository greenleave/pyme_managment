package ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Person;

@Entity
@Table(name="PM_EMPLOYEE")
	public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_EMPLOYEE")
	private TypeOfEmployee typeOfEmplyee;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERSON")
	private Person person;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BEGIN_DATE")
	private Date fechaIngreso;
	
	@Column(name="LEGAJO")
	private String legajo;
	
	@ManyToOne
	@JoinColumn(name="ID_HORARIO_LABORAL")
	private HorarioLaboral horarioLaboral;
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public TypeOfEmployee getTypeOfEmplyee() {
		return typeOfEmplyee;
	}
	
	public void setTypeOfEmplyee(TypeOfEmployee typeOfEmplyee) {
		this.typeOfEmplyee = typeOfEmplyee;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public HorarioLaboral getHorarioLaboral() {
		return horarioLaboral;
	}

	public void setHorarioLaboral(HorarioLaboral horarioLaboral) {
		this.horarioLaboral = horarioLaboral;
	}

}
