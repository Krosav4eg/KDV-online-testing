package Core.apiMethods;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class   GlobalAPI {

	/**
	 * @param apiParameterData- api parameter it must be in JSON format ("url,refresh,access tokens")
	 * @param setData- api data it must be in JSON format
	 * @return ClientResponse from api request
	 */
	public ClientResponse apiPost(JSONObject apiParameterData, JSONObject setData) {
		Client client = Client.create();
		System.out.println(/**************apiPost**************/);
		System.out.println("Post Data API"+ apiParameterData);
		System.out.println("Post Header Data API"+ apiParameterData);
		System.out.println(/**********************************/);
		WebResource webResource = client.resource(apiParameterData.getString("url_name"));
		ClientResponse response = webResource.type("application/json").
				acceptLanguage("u,en-us;q=0.7,en;q=0.3")
				.header(apiParameterData.getString("access_name"),
						apiParameterData.getString("access_token"))
				. header(apiParameterData.getString("refresh_name"),
						apiParameterData.getString("refresh_token"))
				.accept("application/json")
				.post(ClientResponse.class, setData.toString());
		response.bufferEntity();
		System.out.println("POST STATUS GlobalAPI: " + response.getStatus());
		if(response.getStatus()>299)
		{
			System.out.println("POST Body Response: " + response.getEntity(String.class));
		}
		return response;
	}


	/**
	 * @param apiParameterData - api parameter it must be in JSON format ("url,refresh,access tokens")
	 * @return ClientResponse from api request
	 */
	public ClientResponse apiGet(JSONObject apiParameterData) {
		Client client = Client.create();
		System.out.println(/**************apiPost**************/);
		System.out.println("Get Header Data API"+ apiParameterData);
		System.out.println(/********************************/);
		WebResource webResource = client.resource(apiParameterData.getString("url_name"));
		WebResource.Builder bilder = webResource.type("application/json").
				header(apiParameterData.getString("access_name"),
						apiParameterData.getString("access_token"))
				.header(apiParameterData.getString("refresh_name"),
						apiParameterData.getString("refresh_token"))
				.accept("application/json");
		ClientResponse response = bilder.get(ClientResponse.class);
		response.bufferEntity();
		System.out.println("POST STATUS GlobalAPI: " + response.getStatus());
		if(response.getStatus()>299)
		{
			System.out.println("Get Body Response: " + response.getEntity(String.class));
		}
		return response;
	}


	/**
	 * PATCH method was created on standard java library it`s has bad method to get status or entity
	 * it must be refactoring
	 * @param apiParameterData- api parameter it must be in JSON format ("url,refresh,access tokens")
	 * @param patchData- data for patch request
	 * @return ClientResponse from api request
	 */
	protected CloseableHttpResponse apiPatch(JSONObject apiParameterData, JSONObject patchData) throws Exception {
		String postData = patchData.toString();
		System.out.println(/**************apiPatch**************/);
		System.out.println("Patch Data API"+ apiParameterData);
		System.out.println("Patch Header Data API"+ apiParameterData);
		System.out.println(/********************************/);
		CloseableHttpClient httpclient = HttpClients.custom().build();
		HttpPatch httpPatch = new HttpPatch(apiParameterData.getString("url_name"));
		httpPatch.setHeader("Accept", "application/json");
		httpPatch.setHeader("Content-Type", "application/json");
		httpPatch.setHeader(apiParameterData.getString("access_name"), apiParameterData.getString("access_token"));
		httpPatch.setHeader(apiParameterData.getString("refresh_name"), apiParameterData.getString("refresh_token"));
		HttpEntity entity = new ByteArrayEntity(postData.getBytes("utf-8"));
		httpPatch.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httpPatch);
		System.out.println("----------------------------------------");
		System.out.println(response.getStatusLine());
		String responseBody = EntityUtils.toString(response.getEntity());
		System.out.println(responseBody);
		return response;
	}


}
