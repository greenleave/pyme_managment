package ar.com.greenleave.pymeManagment.otrascosas;

import java.util.List;

import ar.com.greenleave.pymeManagment.model.gestionPyme.gestionCliente.Vendor;

public class Sale extends Transaction{

	private Long id;
	private Vendor client;
	private List<Product> products;
	
}
