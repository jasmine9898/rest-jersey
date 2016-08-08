package com.eviac.blog.restclient;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * 
 * @author pavithra
 * 
 */

public class UserInfoClient {

	public static final String BASE_URI = "http://localhost:8280/rest-jersey/";
	public static final String PATH_NAME = "/UserInfoService/name/";
	public static final String PATH_AGE = "/UserInfoService/age/";

	public static void main(String[] args) {

		String name = "ttt";
		int age = 25;

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);

		WebResource nameResource = resource.path("jaxrs").path(PATH_NAME + name);
		System.out.println("Client Response \n"
				+ getClientResponse(nameResource));
		System.out.println("Response \n" + getResponse(nameResource) + "\n\n");

		WebResource ageResource = resource.path("jaxrs").path(PATH_AGE + age);
		System.out.println("Client Response \n"
				+ getClientResponse(ageResource));
		System.out.println("Response \n" + getResponse(ageResource));
	}

	/**
	 * 返回客户端请求。 例如： GET
	 * http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Pavithra
	 * 返回请求结果状态“200 OK”。
	 *
	 * @param service
	 * @return
	 */
	public static String getClientResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class)
				.toString();
	}

	/**
	 * 返回请求结果XML 例如：<User><Name>Pavithra</Name></User>
	 * 
	 * @param service
	 * @return
	 */
	public static String getResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}
}