package ar.com.greenleave.pyme_managment.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

//		CountryDTO country= new CountryDTO();
//		country.setCodPhone("014912");
//		country.setCountry("Canada");
//		country.setCountryCode("CND");
//		ServiceGestionCliente servicio= new ServiceGestionClienteImpl();
//		servicio.savePais(country);
//	}
		
		
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("http://localhost:8080/pymeManagmentController/json/product/post");

			StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);

			org.apache.http.HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Login.getInstance();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }
}