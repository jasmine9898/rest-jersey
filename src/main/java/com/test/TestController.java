package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eviac.blog.restclient.UserInfoClient;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello(){
	}
	@RequestMapping("client.do")
	@ResponseBody
		public String xx(){
		String BASE_URI = "http://localhost:8080/rest-jersey/";
		String PATH_NAME = "/UserInfoService/name/";
		String PATH_AGE = "/UserInfoService/age/";
			String name = "ttt";
			int age = 25;
			StringBuffer stringbuffer=new StringBuffer();

			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
			WebResource resource = client.resource(BASE_URI);

			WebResource nameResource = resource.path("jaxrs").path(PATH_NAME + name);
			stringbuffer.append("Client Response </br>"
					+ UserInfoClient.getClientResponse(nameResource));
			//stringbuffer.append("Response </br>" + UserInfoClient.getResponse(nameResource) + "</br></br>");

/*			WebResource ageResource = resource.path("jaxrs").path(PATH_AGE + age);
			stringbuffer.append("Client Response </br>"
					+ UserInfoClient.getClientResponse(ageResource));
			stringbuffer.append("Response </br>" + UserInfoClient.getResponse(ageResource));*/
			return stringbuffer.toString();
		}
}
