package ar.com.greenleave.pymeManagment.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="PM_CLIENT")
public class Client {

	private Long id;
	private TypeClient typeClient;
	private String Name;
	private String noDocument;
	private TypeDocument typeDocument;
	
}
