package be.fabrictout.dao;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import be.fabrictout.javabeans.*;

public class AreaDAO extends DAO<Area> {

	@Override
	public boolean create(Area obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Area obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id_site", String.valueOf(id));
		paramsPost.add("letter", String.valueOf(obj.getLetter()));
		paramsPost.add("color", String.valueOf(obj.getColor()));
		paramsPost.add("description", obj.getDescription());
		
		ClientResponse res = resource.path("area").post(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Area obj) {
		return false;
	}

	@Override
	public boolean update(Area obj) {
		return false;
	}

	@Override
	public Area find(int id) {
		try {
			Area area = null;
			
			String identifiant = String.valueOf(id);
			
			String responseJSON = resource.path("area")
					.path(identifiant)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);

			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			
			area = new Area(
					jsonNode.get("id").intValue(),
					jsonNode.get("letter").textValue().charAt(0),
					jsonNode.get("color").textValue(),
					jsonNode.get("description").textValue()
					);
			
			JsonNode machineList = jsonNode.get("machineList");
			
			for(JsonNode m : machineList) {
				Machine machine = mapper.readValue(m.toString(), Machine.class);
				area.addMachine(machine);
			}
			
			return area;
			
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Area find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Area> findAll() {
		return null;
	}

	@Override
	public List<Area> findAll(int id) {
		return null;
	}
}