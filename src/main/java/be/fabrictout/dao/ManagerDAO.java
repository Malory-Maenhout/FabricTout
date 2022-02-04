package be.fabrictout.dao;

import java.util.List;
import be.fabrictout.javabeans.Manager;

public class ManagerDAO extends DAO<Manager>{

	@Override
	public boolean create(Manager obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Manager obj) {
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

	@Override
	public Manager find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Manager> findAll() {
		return null;
	}

	@Override
	public List<Manager> findAll(int id) {
		return null;
	}
}