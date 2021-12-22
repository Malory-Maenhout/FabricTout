package be.fabrictout.dao;

import be.fabrictout.javabeans.Machine;

public class MachineDAO extends DAO<Machine> {

	@Override
	public boolean create(Machine obj) {
		return false;
	}

	@Override
	public boolean delete(Machine obj) {
		return false;
	}

	@Override
	public boolean update(Machine obj) {
		return false;
	}

	@Override
	public Machine find(int id) {
		return null;
	}

	@Override
	public Machine find(String str1, String str2) {
		return null;
	}
}