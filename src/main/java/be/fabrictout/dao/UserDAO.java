package be.fabrictout.dao;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.fabrictout.javabeans.*;

public class UserDAO extends DAO<User>{

	@Override
	public boolean create(User obj) {
		return false;
	}

	@Override
	public boolean delete(User obj) {
		return false;
	}

	@Override
	public boolean update(User obj) {
		return false;
	}

	@Override
	public User find(int id) {
		return null;
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
}