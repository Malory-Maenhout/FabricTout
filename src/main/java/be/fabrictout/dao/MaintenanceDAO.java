package be.fabrictout.dao;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import be.fabrictout.javabeans.*;

public class MaintenanceDAO extends DAO<Maintenance>{

	@Override
	public boolean create(Maintenance obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Maintenance obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id_manager", String.valueOf(id));		
		paramsPost.add("date", String.valueOf(obj.getDate()));
		paramsPost.add("duration", String.valueOf(obj.getDuration()));
		paramsPost.add("status", String.valueOf(obj.getStatus()));
		
		String workers = "";
		
		for(int i = 0; i < obj.getWorkerList().size(); i ++) {
			workers += obj.getWorkerList().get(i).getId() + ",";
		}
		
		paramsPost.add("workers", workers);	
		
		paramsPost.add("id_machine", String.valueOf(obj.getMachine().getId()));
		
		ClientResponse res = resource.path("maintenance").post(ClientResponse.class, paramsPost);
	
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Maintenance obj) {
		return false;
	}

	@Override
	public boolean update(Maintenance obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id", String.valueOf(obj.getId()));
		paramsPost.add("date", String.valueOf(obj.getDate()));
		paramsPost.add("duration", String.valueOf(obj.getDuration()));
		paramsPost.add("status", String.valueOf(obj.getStatus()));
		
		ClientResponse res = resource.path("maintenance").put(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return true;
		else
			return false;
	}

	@Override
	public Maintenance find(int id) {
		try {
			Maintenance maintenance = null;
			
			String identifiant = String.valueOf(id);
			
			String responseJSON = resource.path("maintenance")
					.path(identifiant)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);

			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			
			maintenance = mapper.readValue(jsonNode.toString(), Maintenance.class);
					
			return maintenance;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Maintenance find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Maintenance> findAll() {
		return null;
	}

	@Override
	public List<Maintenance> findAll(int id) {
		return null;
	}
}