package be.fabrictout.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import be.fabrictout.javabeans.*;

public class SiteDAO extends DAO<Site>{

	@Override
	public boolean create(Site obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("city", obj.getCity());
		paramsPost.add("country", obj.getCountry());
		
		ClientResponse res = resource.path("site").post(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean create(int id, Site obj) {
		return false;
	}

	@Override
	public boolean delete(Site obj) {
		return false;
	}

	@Override
	public boolean update(Site obj) {
		return false;
	}

	@Override
	public Site find(int id) {
		try {
			Site site = null;
			User user = null;
			
			String identifiant = String.valueOf(id);
			
			String responseJSON = resource.path("site")
					.path(identifiant)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);

			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON, JsonNode.class);
			JsonNode userList = jsonNode.get("userList");
			
			site = new Site(
					jsonNode.get("id").intValue(),
					jsonNode.get("city").textValue(),
					jsonNode.get("country").textValue()
					);
			
			
			for(JsonNode u : userList) {
				String discriminator = u.get("discriminator").textValue();
				
				switch(discriminator)
				{
					case "ADMIN" :
						user = mapper.readValue(u.toString(), Administrator.class);
						break;
						
					case "EMPLOYE" :
						user = mapper.readValue(u.toString(), Employee.class);
						break;
								
					case "MANAGER" :
						user = mapper.readValue(u.toString(), Manager.class);
						break;
								
					case "WORKER" :
						user = mapper.readValue(u.toString(), Worker.class);
						break;
				}
				
				site.addUser(user);
			}
			
			JsonNode areaList = jsonNode.get("areaList");
			
			for(JsonNode a : areaList) {
				Area area = mapper.readValue(a.toString(), Area.class);
				site.addArea(area);
			}
			
			return site;
			
		} 
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Site find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Site> findAll() {
		try {
			List<Site> siteList = new ArrayList<Site>();
			
			String responseJSON = resource.path("site")
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
						
			siteList = mapper.readValue(responseJSON, mapper.getTypeFactory().constructCollectionType(List.class, Site.class));
			
			return siteList;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Site> findAll(int id) {
		return null;
	}
}