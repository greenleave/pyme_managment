package ar.com.greenleave.pymeManagment.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Adress {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="NUMBER")
	private Long number;
	
	@ManyToOne
	@JoinColumn(name="ID_TYPE_ADRESS")
	private TypeAdress typeAdress;
	
//	private String dpto;
//	private String piso;
//	private 
	
}
