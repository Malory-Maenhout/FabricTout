package be.fabrictout.dao;

import be.fabrictout.javabeans.Report;

public class ReportDAO extends DAO<Report>{

	@Override
	public boolean create(Report obj) {
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
}