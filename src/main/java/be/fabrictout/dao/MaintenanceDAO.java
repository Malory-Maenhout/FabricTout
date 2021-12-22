package be.fabrictout.dao;

import be.fabrictout.javabeans.Maintenance;

public class MaintenanceDAO extends DAO<Maintenance>{

	@Override
	public boolean create(Maintenance obj) {
		return false;
	}

	@Override
	public boolean delete(Maintenance obj) {
		return false;
	}

	@Override
	public boolean update(Maintenance obj) {
		return false;
	}

	@Override
	public Maintenance find(int id) {
		return null;
	}

	@Override
	public Maintenance find(String str1, String str2) {
		return null;
	}
}