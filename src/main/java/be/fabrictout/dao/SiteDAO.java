package be.fabrictout.dao;

import be.fabrictout.javabeans.Site;

public class SiteDAO extends DAO<Site>{

	@Override
	public boolean create(Site obj) {
		return false;
	}

	@Override
	public boolean delete(Site obj) {
		return false;
	}

	@Override
	public boolean update(Site obj) {
		return false;
	}

	@Override
	public Site find(int id) {
		return null;
	}

	@Override
	public Site find(String str1, String str2) {
		return null;
	}
}