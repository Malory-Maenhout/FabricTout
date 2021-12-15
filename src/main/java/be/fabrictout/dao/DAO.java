package be.fabrictout.dao;

import java.net.URI;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.UriBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public abstract class DAO<T> {

	//Attributes/Variables
	private static String baseURL = null;
	private Client c;
	protected WebResource resource;
	protected ObjectMapper mapper;

	//Constructor
	public DAO() {
		try {
			Context context = (Context) new InitialContext().lookup("java:comp/env");
			baseURL = (String) context.lookup("baseURL");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		ClientConfig config = new DefaultClientConfig();
		c = Client.create(config);
		resource = c.resource(getBaseURI());
		mapper = new ObjectMapper();
	}

	//Methodes
	public static URI getBaseURI() {
		return UriBuilder.fromUri(baseURL).build();
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T find(int id);
}