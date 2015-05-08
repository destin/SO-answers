package org.dpytel.cxf;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestJacksonJsonProvider {

	@Test
	public void test() {
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
		WebTarget target = client.target("http://jsonplaceholder.typicode.com").path("posts/1");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = builder.get();  // Successful
		Post post = response.readEntity(Post.class);
		System.out.println(post);
		assertEquals(1, post.getId());
	}

}
