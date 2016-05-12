package ar.com.nextel.rest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ar.com.nextel.nexus.model.C;
import ar.com.nextel.nexus.model.ColsData;
import ar.com.nextel.nexus.model.Data;
import ar.com.nextel.nexus.model.V;
import ar.com.nextel.nexus.utils.ConnectionProvider;

public class Prueba {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionProvider.getInstance().getConnection();
		Data data = new Data();
		ColsData primerCols = new ColsData();
		primerCols.setId("");
		primerCols.setLabel("");
		primerCols.setType("number");
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
			
			System.out.println(dataJson);
			
				

		
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}

	}
	
    static <T> List<List<T>> transpose(List<List<T>> table) {
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
