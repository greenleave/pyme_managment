package ar.com.nextel.rest;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import ar.com.nextel.nexus.model.C;
import ar.com.nextel.nexus.model.ColsData;
import ar.com.nextel.nexus.model.Data;
import ar.com.nextel.nexus.model.V;
import ar.com.nextel.nexus.utils.ConnectionProvider;

@Path("/service")
@Component
public class JerseyService {
	
	public static final String CHARSET_UTF8 = "; charset=utf-8";
	private static final Log log = LogFactory.getLog(JerseyService.class);
	
	@GET
	@Path("/json/getDatos")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public String getDatos() throws SQLException {
 
		String jo = getJSONObject();
		return jo;
	}
	
	private String getJSONObject() throws SQLException {
		Connection con = ConnectionProvider.getInstance().getConnection();
		Data data = new Data();
		ColsData primerCols = new ColsData();
		primerCols.setId("x");
		primerCols.setLabel("x");
		primerCols.setType("string");
		data.addColsData(primerCols);
		List<List<String>> lista = new ArrayList<>();
		try {
			String query = "select status_tx as descripcion, count(1) as cantidad, '500', '1400', '350' from vw_soporte_transacciones where fecha > sysdate -365 group by status_tx";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultados = statement.executeQuery();
			int cantColumnas = resultados.getMetaData().getColumnCount(); // n campos
			
			List<String> listaNombresColumnas = new ArrayList<>();
			while(resultados.next()) {
				List<String> subLista = new ArrayList<>();
				int row = resultados.getRow();
				for (int i = 1; i <= cantColumnas; i++) {
					if (i != 1) {
						if (row == 1) {
							listaNombresColumnas.add(resultados.getMetaData().getColumnName(i));
						}
						subLista.add(resultados.getObject(i).toString());
					} else {
						ColsData colsData = new ColsData();
						colsData.setId(resultados.getObject(i).toString());
						colsData.setLabel(resultados.getObject(i).toString());
						colsData.setType("number");
						data.addColsData(colsData);
					}
				}
				if (row == 1) {
					lista.add(listaNombresColumnas);
				}
				lista.add(subLista);
			}
			
			List<List<String>> transpose = transpose(lista);
			
			for (Iterator<List<String>> iterator = transpose.iterator(); iterator.hasNext();) {
				List<String> list = (List<String>) iterator.next();
				C c = new C();
				for (Iterator<String> iterator2 = list.iterator(); iterator2.hasNext();) {
					String string = (String) iterator2.next();
					V v = new V();
					v.setV(string);
					c.addV(v);
					
				}
				data.addC(c);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);	
			
			String dataJson = mapper.writeValueAsString(data);
			
			return dataJson;
			

		} catch (JsonGenerationException e) {
			log.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			con.close();
		}
		return null;

	}
	
    private <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }	
 
}