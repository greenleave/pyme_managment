package ar.com.greenleave.pymeManagment.model.gestionCliente;

public class TypeProduct {

	private Long id;
	private String descripcion;
	
	/**
	 * En caso de necesitar un "tipo de subproducto"
	 */
	private TypeProduct father;
	
}
