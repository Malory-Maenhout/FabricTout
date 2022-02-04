package be.fabrictout.dao;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import be.fabrictout.javabeans.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class UserDAO extends DAO<User>{

	@Override
	public boolean create(User obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, User obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id_site", String.valueOf(id));
		paramsPost.add("firstname", obj.getFirstname());
		paramsPost.add("lastname", obj.getLastname());
		paramsPost.add("address", obj.getAddress());
		paramsPost.add("dateOfBirth", obj.getDateOfBirth().toString());
		paramsPost.add("sexe", String.valueOf(obj.getSexe()));
		paramsPost.add("city", obj.getCity());
		paramsPost.add("postalCode", String.valueOf(obj.getPostalCode()));
		paramsPost.add("phoneNumber", String.valueOf(obj.getPhoneNumber()));
		paramsPost.add("emailAddress", obj.getEmailAddress());
		paramsPost.add("personnelnumber", obj.getPersonnelNumber());
		paramsPost.add("password", obj.getPassword());
		paramsPost.add("discriminator", obj.getDiscriminator());
		
		ClientResponse res = resource.path("user").post(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(User obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id", String.valueOf(obj.getId()));
		paramsPost.add("firstname", obj.getFirstname());
		paramsPost.add("lastname", obj.getLastname());
		paramsPost.add("address", obj.getAddress());
		paramsPost.add("dateOfBirth", obj.getDateOfBirth().toString());
		paramsPost.add("sexe", String.valueOf(obj.getSexe()));
		paramsPost.add("city", obj.getCity());
		paramsPost.add("postalCode", String.valueOf(obj.getPostalCode()));
		paramsPost.add("phoneNumber", String.valueOf(obj.getPhoneNumber()));
		paramsPost.add("emailAddress", obj.getEmailAddress());
		paramsPost.add("personnelnumber", obj.getPersonnelNumber());
		paramsPost.add("password", obj.getPassword());
		paramsPost.add("discriminator", obj.getDiscriminator());
		paramsPost.add("active", String.valueOf(obj.isActive()));
		
		ClientResponse res = resource.path("user").put(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(User obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id", String.valueOf(obj.getId()));
		paramsPost.add("firstname", obj.getFirstname());
		paramsPost.add("lastname", obj.getLastname());
		paramsPost.add("address", obj.getAddress());
		paramsPost.add("dateOfBirth", obj.getDateOfBirth().toString());
		paramsPost.add("sexe", String.valueOf(obj.getSexe()));
		paramsPost.add("city", obj.getCity());
		paramsPost.add("postalCode", String.valueOf(obj.getPostalCode()));
		paramsPost.add("phoneNumber", String.valueOf(obj.getPhoneNumber()));
		paramsPost.add("emailAddress", obj.getEmailAddress());
		paramsPost.add("personnelnumber", obj.getPersonnelNumber());
		paramsPost.add("password", obj.getPassword());
		paramsPost.add("discriminator", obj.getDiscriminator());
		paramsPost.add("active", String.valueOf(obj.isActive()));
		
		ClientResponse res = resource.path("user").put(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return true;
		else
			return false;
	}

	@Override
	public User find(int id) {
		try {
			User user = null;
			String identifiant = String.valueOf(id);
			
			String responseJSON = resource.path("user")
					  .path(identifiant)
					  .accept(MediaType.APPLICATION_JSON)
					  .get(String.class);
			
			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			String discriminator = jsonNode.get("discriminator").textValue();
					
			switch(discriminator)
			{
				case "ADMIN" :
					user = mapper.readValue(responseJSON, Administrator.class);
					break;
					
				case "EMPLOYE" :
					user = mapper.readValue(responseJSON, Employee.class);
					break;
							
				case "MANAGER" :
					user = mapper.readValue(responseJSON, Manager.class);
					break;
							
				case "WORKER" :
					user = mapper.readValue(responseJSON, Worker.class);
					break;
			}
					
			return user;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public User find(String personnelNumber, String password) {	
		try {
			User user = null;
			
			String responseJSON = resource.path("user")
					  .path(personnelNumber)
					  .path(password)
					  .accept(MediaType.APPLICATION_JSON)
					  .get(String.class);		
			
			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			String discriminator = jsonNode.get("discriminator").textValue();
					
			switch(discriminator)
			{
				case "ADMIN" :
					user = mapper.readValue(responseJSON, Administrator.class);
					break;
					
				case "EMPLOYE" :
					user = mapper.readValue(responseJSON, Employee.class);
					break;
							
				case "MANAGER" :
					user = mapper.readValue(responseJSON, Manager.class);
					break;
							
				case "WORKER" :
					user = mapper.readValue(responseJSON, Worker.class);
					break;
			}
					
			return user;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public List<User> findAll(int id) {
		return null;
	}
}