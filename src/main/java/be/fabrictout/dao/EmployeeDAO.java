package be.fabrictout.dao;

import java.util.List;
import be.fabrictout.javabeans.Employee;

public class EmployeeDAO extends DAO<Employee> {

	@Override
	public boolean create(Employee obj) {
		return false;
	}
	
	@Override
	public boolean create(int id, Employee obj) {
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

	@Override
	public Employee find(String str1, String str2) {
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Override
	public List<Employee> findAll(int id) {
		return null;
	}
}