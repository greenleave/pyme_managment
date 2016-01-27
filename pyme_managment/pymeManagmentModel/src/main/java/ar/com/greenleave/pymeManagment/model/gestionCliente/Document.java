package ar.com.greenleave.pymeManagment.model.gestionCliente;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="hola")
public class Document {

	private Long id;
	private TypeDocument typeDocument;
	private String noDocument;
	
}
