package ar.com.greenleave.pyme_managment.main;

import ar.com.greenleave.pyme_managment.view.dto.CountryDTO;
import ar.com.greenleave.pyme_managment.view.services.ServiceGestionCliente;
import ar.com.greenleave.pyme_managment.view.services.impl.ServiceGestionClienteImpl;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		CountryDTO country = new CountryDTO();
		country.setCodPhone("014912");
		country.setCountry("Canada");
		country.setCountryCode("CND");
		ServiceGestionCliente servicio = new ServiceGestionClienteImpl();
		servicio.savePais(country);
	}

	// try {
	//
	// DefaultHttpClient httpClient = new DefaultHttpClient();
	// HttpPost postRequest = new
	// HttpPost("http://localhost:6163/pymeManagmentController/gestionCliente/createNewCountry");
	// StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad
	// 4\"}");
	// input.setContentType("application/json");
	// postRequest.setEntity(input);
	//
	// org.apache.http.HttpResponse response = httpClient.execute(postRequest);
	//
	// if (response.getStatusLine().getStatusCode() != 201) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatusLine().getStatusCode());
	// }
	//
	// BufferedReader br = new BufferedReader(new
	// InputStreamReader((response.getEntity().getContent())));
	//
	// String output;
	// System.out.println("Output from Server .... \n");
	// while ((output = br.readLine()) != null) {
	// System.out.println(output);
	// }
	//
	// httpClient.getConnectionManager().shutdown();
	//
	// } catch (MalformedURLException e) {
	//
	// e.printStackTrace();
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	//
	// }
	//
	// }
	//
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
