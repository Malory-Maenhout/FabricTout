package be.fabrictout.javabeans;

import java.io.Serializable;
import java.util.*;
import be.fabrictout.dao.SiteDAO;

public class Site implements Serializable{

	//Attributes/Variables
	private static final long serialVersionUID = -2029987917469699914L;
	private int id;
	private String city;
	private String country;
	private List<User> userList = new ArrayList<User>();
	private List<Area> areaList = new ArrayList<Area>();
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}	
	public void addUser(User user) {
			this.userList.add(user);
	}	
	public void removeUser(User user) {
		this.userList.remove(user);
	}
	
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}	
	public void addArea(Area area) {
			this.areaList.add(area);
	}	
	public void removeArea(Area area) {
		this.areaList.remove(area);
	}
	
	//Constructor
	public Site() {
		super();
	}

	public Site(int id, String city, String country) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
	}
	
	public Site(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	//Methodes
	public static Site getSite(int id)
	{
		SiteDAO dao = new SiteDAO();
		return dao.find(id);
	}
}