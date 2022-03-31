package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA {

//... importa definición de clase...

	// Dentro de la clase:
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();

	// PARA HACER: Implementar un constructor que tome un ID y un rol
	public UsuarioAdmin(Integer employeeID, String role) {
		super();
		this.employeeID = employeeID;
		this.role = role;
	}

	// PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!copy
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin > 99999) {
			setPin(pin);
			return true;
		}
		return false;
	}

	// PARA HACER: ¡Implementar AdminCompatibleConHIPAA
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == employeeID) {
			return true;
		}
		authIncident();
		return false;
	}

	public void newIncident(String notes) {
		String report = String.format("Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", new Date(), this.id,
				"FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO");
		securityIncidents.add(report);
	}

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
