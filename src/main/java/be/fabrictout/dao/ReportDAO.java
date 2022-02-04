package be.fabrictout.dao;

import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import be.fabrictout.javabeans.Report;

public class ReportDAO extends DAO<Report>{

	@Override
	public boolean create(Report obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Report obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("id_maintenance", String.valueOf(id));
		paramsPost.add("id_worker", String.valueOf(obj.getWorker().getId()));
		paramsPost.add("description", obj.getDescription());
		paramsPost.add("date", String.valueOf(obj.getDate()));
		
		ClientResponse res = resource.path("report").post(ClientResponse.class, paramsPost);
		
		int httpResponseCode = res.getStatus();
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Report obj) {
		return false;
	}

	@Override
	public boolean update(Report obj) {
		return false;
	}

	@Override
	public Report find(int id) {
		return null;
	}

	@Override
	public Report find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Report> findAll() {
		return null;
	}

	@Override
	public List<Report> findAll(int id) {
		return null;
	}
}