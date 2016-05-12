package ar.com.nextel.nexus.model;
import java.util.ArrayList;
import java.util.List;


public class C {

	private List<V> c = new ArrayList<>();

	public List<V> getC() {
		return c;
	}

	public void setC(List<V> c) {
		this.c = c;
	}
	
	public void addV(V v) {
		c.add(v);
	}
	
	@Override
	public String toString() {
		return "c: " + c;
	}
	
}
