package be.fabrictout.dao;

import be.fabrictout.javabeans.Employee;

public class EmployeeDAO extends DAO<Employee> {

	@Override
	public boolean create(Employee obj) {
		return false;
	}

	@Override
	public boolean delete(Employee obj) {
		return false;
	}

	@Override
	public boolean update(Employee obj) {
		return false;
	}

	@Override
	public Employee find(int id) {
		return null;
	}
}