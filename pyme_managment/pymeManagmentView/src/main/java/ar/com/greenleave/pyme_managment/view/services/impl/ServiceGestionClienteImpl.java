package ar.com.greenleave.pyme_managment.view.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import ar.com.greenleave.pyme_managment.view.dto.CountryDTO;
import ar.com.greenleave.pyme_managment.view.exception.GsonException;
import ar.com.greenleave.pyme_managment.view.services.ServiceGestionCliente;

public class ServiceGestionClienteImpl implements ServiceGestionCliente {
	private static final String HOST_PAGE = "http://localhost:8080/pymeManagmentController/";
	private static Gson gson = new Gson();
	DefaultHttpClient httpClient = new DefaultHttpClient();

	@Override
	public void savePais(CountryDTO country) {
		try {
			HttpResponse response = httpClient.execute(getPostRequest("gestionCliente/createNewCountry", country));
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

		} catch (GsonException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CountryDTO> getAllContry() {
		try {
			HttpResponse response = httpClient.execute(getPostRequest("gestionCliente/getAllContry"));
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
		return null;
	}
	
	
	private HttpPost getPostRequest(String path){
		return new HttpPost(HOST_PAGE+path);
	}
	
	private HttpPost getPostRequest(String path, Object object)throws GsonException{
		HttpPost httpPost= new HttpPost(HOST_PAGE + path);
		StringEntity input;
		try {
			input = new StringEntity(gson.toJson(object));
			input.setContentType("application/json");
			httpPost.setEntity(input);
			return httpPost;
		} catch (UnsupportedEncodingException e) {
			throw new GsonException();
		}
	}
}
