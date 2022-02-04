package be.fabrictout.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import be.fabrictout.javabeans.Worker;

public class WorkerDAO extends DAO<Worker> {

	@Override
	public boolean create(Worker obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Worker obj) {
		return false;
	}

	@Override
	public boolean delete(Worker obj) {
		return false;
	}

	@Override
	public boolean update(Worker obj) {
		return false;
	}

	@Override
	public Worker find(int id) {
		return null;
	}

	@Override
	public Worker find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Worker> findAll() {
		return null;
	}

	@Override
	public List<Worker> findAll(int id) {
		try {
			List<Worker> workerList = new ArrayList<Worker>();
			
			String responseJSON = resource.path("user/workers")
					.path(String.valueOf(id))
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
						
			workerList = mapper.readValue(responseJSON, mapper.getTypeFactory().constructCollectionType(List.class, Worker.class));
			
			return workerList;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}