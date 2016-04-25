package ar.com.greenleave.pymeManagment.model.gestionPyme.gestionEmpleados;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PM_HORARIO_LABORAL")
public class HorarioLaboral {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Temporal(TemporalType.TIME)
	@Column(name="HORARIO_ENTRADA")
	private Time horarioEntrada;
	@Temporal(TemporalType.TIME)
	@Column(name="HORARIO_SALIDA")
	private Time horarioSalida;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Time getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(Time horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public Time getHorarioSalida() {
		return horarioSalida;
	}
	public void setHorarioSalida(Time horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

}
