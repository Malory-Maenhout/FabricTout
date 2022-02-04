package be.fabrictout.dao;

import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import be.fabrictout.javabeans.*;

public class MachineDAO extends DAO<Machine> {

	@Override
	public boolean create(Machine obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", obj.getName());
		paramsPost.add("serialNumber", obj.getSerialNumber());
		paramsPost.add("size", String.valueOf(obj.getSize()));
		paramsPost.add("status", String.valueOf(obj.getStatus()));
		paramsPost.add("type", String.valueOf(obj.getType()));	
		
		String areas = "";
		
		for(int i = 0; i < obj.getAreaList().size(); i ++) {
			areas += obj.getAreaList().get(i).getId() + ",";
		}
		
		paramsPost.add("areas", areas);	
		
		ClientResponse res = resource.path("machine").post(ClientResponse.class, paramsPost);
	
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean create(int id, Machine obj) {
		return false;
	}

	@Override
	public boolean delete(Machine obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id", String.valueOf(obj.getId()));
		paramsPost.add("name", obj.getName());
		paramsPost.add("size", String.valueOf(obj.getSize()));
		paramsPost.add("status",  String.valueOf(obj.getStatus()));
		paramsPost.add("replace", String.valueOf(obj.isReplace()));
		paramsPost.add("serialNumber", obj.getSerialNumber());
		paramsPost.add("type", String.valueOf(obj.getType()));
		
		ClientResponse res = resource.path("machine").put(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(Machine obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id", String.valueOf(obj.getId()));
		paramsPost.add("name", obj.getName());
		paramsPost.add("size", String.valueOf(obj.getSize()));
		paramsPost.add("status",  String.valueOf(obj.getStatus()));
		paramsPost.add("replace", String.valueOf(obj.isReplace()));
		paramsPost.add("serialNumber", obj.getSerialNumber());
		paramsPost.add("type", String.valueOf(obj.getType()));
		
		ClientResponse res = resource.path("machine").put(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return true;
		else
			return false;
	}

	@Override
	public Machine find(int id) {
		try {
			Machine machine = null;
			
			String identifiant = String.valueOf(id);
			
			String responseJSON = resource.path("machine")
					.path(identifiant)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);

			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			
			machine = new Machine(
					jsonNode.get("id").intValue(),
					jsonNode.get("name").textValue(),
					jsonNode.get("size").textValue(),
					jsonNode.get("status").textValue(),
					jsonNode.get("replace").asBoolean(),
					jsonNode.get("serialNumber").textValue(),
					jsonNode.get("type").textValue()
					);
			
			JsonNode maitenanceList = jsonNode.get("maintenanceList");
			for(JsonNode m : maitenanceList) {
				Maintenance maintenance= mapper.readValue(m.toString(), Maintenance.class);
				machine.addMaintenance(maintenance);
			}
			
			JsonNode areaList = jsonNode.get("areaList");
			for(JsonNode a : areaList) {
				Area area = mapper.readValue(a.toString(), Area.class);
				machine.addArea(area);
			}
			
			return machine;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Machine find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Machine> findAll() {
		return null;
	}

	@Override
	public List<Machine> findAll(int id) {
		return null;
	}
}