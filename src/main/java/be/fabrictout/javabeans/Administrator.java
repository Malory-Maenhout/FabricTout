package be.fabrictout.javabeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;
import be.fabrictout.dao.*;

public class Administrator extends User implements Serializable{

	//Attributes/Variables
	private static final long serialVersionUID = -6911865646074346565L;	
	private List<Site> siteList = new ArrayList<Site>();
	
	//Getters & Setters
	public List<Site> getSiteList() {
		return siteList;
	}
	public void setSiteList(List<Site> siteList) {
		this.siteList = siteList;
	}	
	public void addSite(Site site) {
			this.siteList.add(site);
	}	
	public void removeSite(Site site) {
		this.siteList.remove(site);
	}
	
	//Constructor
	public Administrator() {
		super();
	}
	
	public Administrator(int id, String firstname, String lastname, String address, Date dateOfBirth, char sexe, String city,
			int postalCode, int phoneNumber, String emailAddress, String personnelNumber, String password, String discriminator, boolean active) {
		super(id, firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator, 
				active);
	}
	
	//Methodes	
	public boolean createUser(int id, User addUser) {
		UserDAO dao = new UserDAO();
		return dao.create(id, addUser);
	}
	
	public boolean deleteUser(User deleteUser) {
		UserDAO dao = new UserDAO();
		return dao.delete(deleteUser);
	}
	
	public boolean editUser(User editUser) {
		UserDAO dao = new UserDAO();
		return dao.update(editUser);
	}
	
	public boolean createSite(Site addSite) {
		SiteDAO dao = new SiteDAO();
		return dao.create(addSite);
	}
	
	public void loadSiteList() {
		SiteDAO dao = new SiteDAO();
		this.siteList = dao.findAll();
	}
	
	public boolean createArea(int id, Area addArea) {
		AreaDAO dao = new AreaDAO();
		return dao.create(id, addArea);
	}
}