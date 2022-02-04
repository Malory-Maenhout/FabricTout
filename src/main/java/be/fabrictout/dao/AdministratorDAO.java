package be.fabrictout.dao;

import java.util.List;
import be.fabrictout.javabeans.Administrator;

public class AdministratorDAO extends DAO<Administrator> {

	@Override
	public boolean create(Administrator obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Administrator obj) {
		return false;
	}

	@Override
	public boolean delete(Administrator obj) {
		return false;
	}

	@Override
	public boolean update(Administrator obj) {
		return false;
	}

	@Override
	public Administrator find(int id) {
		return null;
	}

	@Override
	public Administrator find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Administrator> findAll() {
		return null;
	}

	@Override
	public List<Administrator> findAll(int id) {
		return null;
	}
}