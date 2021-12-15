package be.fabrictout.dao;

import be.fabrictout.javabeans.Manager;

public class ManagerDAO extends DAO<Manager>{

	@Override
	public boolean create(Manager obj) {
		return false;
	}

	@Override
	public boolean delete(Manager obj) {
		return false;
	}

	@Override
	public boolean update(Manager obj) {
		return false;
	}

	@Override
	public Manager find(int id) {
		return null;
	}
}