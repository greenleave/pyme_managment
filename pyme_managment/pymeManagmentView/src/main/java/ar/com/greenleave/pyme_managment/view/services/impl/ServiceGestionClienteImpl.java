package ar.com.greenleave.pyme_managment.view.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import ar.com.greenleave.pyme_managment.view.dto.CountryDTO;
import ar.com.greenleave.pyme_managment.view.services.ServiceGestionCliente;

public class ServiceGestionClienteImpl implements ServiceGestionCliente {
	private static final String HOST_PAGE = "http://localhost:6163/pymeManagmentController/";
	private static Gson gson = new Gson();
	DefaultHttpClient httpClient = new DefaultHttpClient();

	@Override
	public void savePais(CountryDTO country) {
		String path = "gestionCliente/createNewCountry";
		System.out.println(HOST_PAGE+path);
		HttpPost postRequest = new HttpPost(HOST_PAGE+path);
		StringEntity input;
		try {
			input = new StringEntity(gson.toJson(country) );
			input.setContentType("application/json");
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
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
}
