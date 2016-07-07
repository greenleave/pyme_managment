package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.ComunicacionService;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.utils.DireccionesEnum;

@Service("comunicacionService")
public class ComunicacionServiceImpl implements ComunicacionService {
	private final String USER_AGENT = "Mozilla/5.0";
	
	private String json;
	private URL url;
	private HttpURLConnection connection;
	private BufferedReader br;

	@Override
	public void loguearPersona(String json) {
		System.out.println("Esta es la dirección:  " + json);
		String direccion = DireccionesEnum.ROOT.getDireccion() + DireccionesEnum.USER_CENTER.getDireccion()
				+ DireccionesEnum.LOGIN.getDireccion();
		System.out.println(direccion);
		this.sendPost(direccion, json);
	}

	private void sendPost(String direccion, String json) {
		try {
			URL url = new URL(direccion);
			this.json=json;
			//Mando a configurar la conexión (patrón dry)
			HttpURLConnection conn = this.configConection(url);
			//Envio el mensaje
			this.sendMensagge();
			System.out.println("Output from Server .... \n");
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private HttpURLConnection configConection(URL url) throws Exception{
		
		try {
			this.connection = (HttpURLConnection) url.openConnection();
			this.connection.setDoOutput(true);
			this.connection.setRequestMethod("POST");
			this.connection.setRequestProperty("Content-Type", "application/json");
			return this.connection;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	
	private void sendMensagge() throws Exception{
		OutputStream os;
		try {
			os = this.connection.getOutputStream();
			os.write(json.getBytes());
			os.flush();
			if (this.connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + this.connection.getResponseCode());
			}
			this.br = new BufferedReader(new InputStreamReader((this.connection.getInputStream())));
		} catch (IOException e) {
			//TODO: modificar el exeption
			throw new Exception();
		}
	}

}
