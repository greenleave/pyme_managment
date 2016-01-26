package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.Date;
import java.util.List;

public abstract class Transaction {
	private Long id;
	private TypeOfTransaction typeOfTransaction;
	private Date date;
	private String description;
	private List<Debe> debe;
	private List<Haber> haber;
	
}
