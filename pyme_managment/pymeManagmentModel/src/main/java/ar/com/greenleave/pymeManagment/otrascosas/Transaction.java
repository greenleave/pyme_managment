package ar.com.greenleave.pymeManagment.otrascosas;

import java.util.Date;
import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.TypeOfTransaction;

public abstract class Transaction {
	private Long id;
	private TypeOfTransaction typeOfTransaction;
	private Date date;
	private String description;
	private List<Debe> debe;
	private List<Haber> haber;
	
}
