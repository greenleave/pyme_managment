package ar.com.nextel.utils;

public class StoredProcedureParamsIn {
	private int tipo;
	private Object valor;
	private String nombre;
	
	public StoredProcedureParamsIn() {
	}
	
	public StoredProcedureParamsIn(Object valor, int tipo, String nombre) {
		this.valor = valor;
		this.setTipo(tipo);
		this.setNombre(nombre);
	}
	
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}	

	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
