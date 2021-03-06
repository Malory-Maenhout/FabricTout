package be.fabrictout.javabeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import be.fabrictout.dao.ReportDAO;

public class Worker extends User implements Serializable {

	//Attributes/Variables
	private static final long serialVersionUID = 288501069493727942L;
	private List<Maintenance> maintenanceList = new ArrayList<Maintenance>();
	
	//Getters & Setters
	public List<Maintenance> getMaintenanceList() {
		return maintenanceList;
	}
	public void setMaintenanceList(List<Maintenance> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}	
	public void addMaintenance(Maintenance maintenance) {
			this.maintenanceList.add(maintenance);
	}	
	public void removeMaintenance(Maintenance maintenance) {
		this.maintenanceList.remove(maintenance);
	}
	
	//Constructor
	public Worker() {
		super();
	}
	
	public Worker(int id, String firstname, String lastname, String address, Date dateOfBirth, char sexe, String city,
			int postalCode, int phoneNumber, String emailAddress, String personnelNumber, String password, String discriminator, boolean active) {
		super(id, firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator,
				active);
	}	
	
	public Worker(String firstname, String lastname, String address, Date dateOfBirth, char sexe, String city,
			int postalCode, int phoneNumber, String emailAddress, String personnelNumber, String password, String discriminator, boolean active) {
		super(firstname, lastname, address, dateOfBirth, sexe, city, postalCode, phoneNumber, emailAddress, personnelNumber, password, discriminator,
				active);
	}
	
	//Methodes	
	public boolean createReport(int id, Report report) {
		ReportDAO dao = new ReportDAO();
		return dao.create(id, report);
	}
}