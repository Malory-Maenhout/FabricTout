package be.fabrictout.javabeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

public class Employee extends User implements Serializable {

	//Attributes/Variables
	private static final long serialVersionUID = -6889962153504587075L;
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
	public Employee() {
		super();
	}
	
	public Employee(String firstname, String lastname, String address, Date dateOfBirth, char sexe, String city,
			int postalCode, int phoneNumber, String emailAddress, String matricule, String password, boolean active) {
		super(firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, matricule, password,
				active);
	}
	
	//Methodes
	
}