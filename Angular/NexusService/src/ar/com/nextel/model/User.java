package ar.com.nextel.model;

import java.math.BigDecimal;

/**
 * <p>
 * <b>Name:</b> 
 * </p>
 *
 * @since 
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
public class User {
	
	private BigDecimal id;
	private String name;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
