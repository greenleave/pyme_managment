package ar.com.greenleave.pymeManagment.gestionCliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PM_ADRESS")
public class Adress {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="NUM")
	private Long number;
	
	@Column(name="APARTMENT")
	private String apartment;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_ADRESS")
	private TypeAdress typeAdress;
	
}
