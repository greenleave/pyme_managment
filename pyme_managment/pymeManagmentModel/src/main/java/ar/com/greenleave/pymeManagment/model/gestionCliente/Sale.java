package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.List;

public class Sale extends Transaction{

	private Long id;
	private Vendor client;
	private List<Product> products;
	
}