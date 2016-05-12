package ar.com.nextel.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * <b>Name:</b> Setting
 * </p>
 *
 * @since 
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
public class Setting implements Serializable{	

	private BigDecimal settingId;
	private String description;
	private BigDecimal userId;
	
	public Setting(){
		
	}
	
	public Setting(BigDecimal settingId, String description, BigDecimal userId) {		
		this.settingId = settingId;
		this.description = description;
		this.userId = userId;
	}	
	
	public BigDecimal getSettingId() {
		return settingId;
	}
	public void setSettingId(BigDecimal settingId) {
		this.settingId = settingId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getUserId() {
		return userId;
	}
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	

}
