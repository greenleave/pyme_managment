package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.Date;

public abstract class Transaction {
	private Long id;
	private TypeOfTransaction typeOfTransaction;
	private Date date;
	private String description;
	
}
