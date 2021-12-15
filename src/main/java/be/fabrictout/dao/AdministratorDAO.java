package be.fabrictout.dao;

import be.fabrictout.javabeans.Administrator;

public class AdministratorDAO extends DAO<Administrator> {

	@Override
	public boolean create(Administrator obj) {
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
}