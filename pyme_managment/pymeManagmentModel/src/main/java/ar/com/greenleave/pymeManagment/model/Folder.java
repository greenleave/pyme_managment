package ar.com.greenleave.pymeManagment.model;

import java.util.Date;
import java.util.List;

public class Folder {

	private Long id;
//Lista de transacciones que se encuentran en la carpeta
	private List<Transaction> transactions;
	
//	Fecha que se abre la carpeta
	private Date open;
	
// 	Fecha que cierra la carpeta
	private Date close;
	
}
