package ar.com.nextel.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class GenericStoredProcedure extends StoredProcedure {
	
	private List parametros;
	
	public GenericStoredProcedure() {
	}
	
	public GenericStoredProcedure(String procedureName, List params, JdbcTemplate jdbcTemplate) {
		setSql(procedureName);		
		setJdbcTemplate(jdbcTemplate);
		this.parametros = params;
	}
	
	public Map executeSp(){

		Iterator iterator = parametros.iterator();
		Map parametrosIn = new HashMap();
		while (iterator.hasNext()) {
			
			Object parametro = iterator.next();
			
			if(parametro instanceof StoredProcedureParamsIn){
				StoredProcedureParamsIn parametroEntrada = (StoredProcedureParamsIn)parametro;
				
				int type = parametroEntrada.getTipo();				
				Object valor = parametroEntrada.getValor();
				declareParameter(new SqlParameter(parametroEntrada.getNombre(),type));				
				parametrosIn.put(parametroEntrada.getNombre(),valor);
			}else{				
				StoredProcedureParamsOut parametroOut = ((StoredProcedureParamsOut)parametro);
				declareParameter(new SqlOutParameter(parametroOut.getNombre(), parametroOut.getTipo()));
			}
			
		}
		
		compile();		
		return execute(parametrosIn);		
		
	}

}
