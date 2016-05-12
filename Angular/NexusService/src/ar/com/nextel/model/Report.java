package ar.com.nextel.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.json.JsonObject;

/**
 * <p>
 * <b>Name:</b> Chart
 * </p>
 * <p>
 *
 * @since 
 * @author Fernando N. Tobares García
 * @version v1.0
 * 
 */
public class Report {

	 private BigDecimal id;
	 private String description;
	 private String queryStmt;
	 private JsonObject jsonConfiguration;
	 private JsonObject jsonData;
	 private Timestamp lastTimeExecuted;
	 private BigDecimal refreshTime;
	 
	public Report(){
		
	}
	 
	public Report(BigDecimal id, 
				  String description,
				  String queryStmt,
				  JsonObject jsonConfiguration,
				  JsonObject jsonData,
				  Timestamp lastTimeExecuted,
				  BigDecimal refreshTime){
		this.id = id;
		this.description = description;
		this.queryStmt = queryStmt;
		this.jsonConfiguration = jsonConfiguration;
		this.jsonData = jsonData;
		this.lastTimeExecuted = lastTimeExecuted;
		this.refreshTime = refreshTime;
	}
	 
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getQueryStmt() {
		return queryStmt;
	}	
	public void setQueryStmt(String queryStmt) {
		this.queryStmt = queryStmt;
	}
	
	public JsonObject getJsonConfiguration() {
		return jsonConfiguration;
	}
	public void setJsonConfiguration(JsonObject jsonConfiguration) {
		this.jsonConfiguration = jsonConfiguration;
	}
	
	public JsonObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JsonObject jsonData) {
		this.jsonData = jsonData;
	}
	
	public Timestamp getLastTimeExecuted() {
		return lastTimeExecuted;
	}
	public void setLastTimeExecuted(Timestamp lastTimeExecuted) {
		this.lastTimeExecuted = lastTimeExecuted;
	}
	
	public BigDecimal getRefreshTime() {
		return refreshTime;
	}
	public void setRefreshTime(BigDecimal refreshTime) {
		this.refreshTime = refreshTime;
	}	

}
