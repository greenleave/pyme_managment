package ar.com.nextel.utils;

public class StoredProcedureParamsOut {
	private int tipo;
	private String nombre;
	
	public StoredProcedureParamsOut() {
	}
	
	public StoredProcedureParamsOut(int tipo, String nombre) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getTipo() {
		return tipo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
