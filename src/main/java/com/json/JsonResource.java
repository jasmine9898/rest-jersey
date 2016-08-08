package com.json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//http://localhost:8280/rest-jersey/jaxrs/test/getHello/world/100

@Path("test")
public class JsonResource {

    @GET
    @Path("createSimpleBean")
    @Produces( MediaType.APPLICATION_JSON)
    public TestBean createSimpleBean() {
        return new TestBean("a", 1, 1L);
    }
    
    @GET
    @Path("getHello/{some}/{flag}")
    @Produces("text/plain")
    public String getHello(@PathParam(value="some")String somebody, @PathParam(value="flag")int flag) {
        return "Hello World!" + somebody + "-" + flag;
    }
}