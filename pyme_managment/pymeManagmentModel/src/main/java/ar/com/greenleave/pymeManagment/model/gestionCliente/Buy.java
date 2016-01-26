package ar.com.greenleave.pymeManagment.model.gestionCliente;

import java.util.ArrayList;
import java.util.List;

public class Buy extends Transaction{
	
	private Long id;
	private List<Product> products;
	
	public Buy(){
		this.products=new ArrayList<Product>();
	}
	
	
}
