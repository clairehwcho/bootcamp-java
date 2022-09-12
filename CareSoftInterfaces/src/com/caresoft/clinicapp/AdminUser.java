package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, Integer employeeID, String role) {
		super(id);
		this.employeeID = employeeID;
		this.role = role;
	}

	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    public boolean assignPin(int pin) {
    	String pinString = Integer.toString(pin);
    	if (pinString.length() < 6) {
    		return false;
    	}
    	else {
    		super.setPin(pin);
    	}
    	return true;
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (super.id.equals(confirmedAuthID)) {
    		return true;
    	}
    	else {
    		this.authIncident();
    	}
    	return false;
    }
    
    public ArrayList<String> reportSecurityIncidents(){
    	return this.getSecurityIncidents();
    }
	
	// TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
