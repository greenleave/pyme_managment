package ar.com.greenleave.pymeManagment.viewDesktop.DTO.GestionCliente;


public class TypeProductDTO {
	private Long id;
	
	private String descripcion;
	
	/**
	 * En caso de necesitar un "tipo de subproducto"
	 */
	private TypeProductDTO father;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TypeProductDTO getFather() {
		return father;
	}

	public void setFather(TypeProductDTO father) {
		this.father = father;
	}
	
}
