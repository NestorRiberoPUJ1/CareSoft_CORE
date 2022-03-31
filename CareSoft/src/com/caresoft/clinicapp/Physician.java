package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA {

//... importa definición de clase...

	// Dentro de la clase:
	private ArrayList<String> patientNotes;

	// PARA HACER: Constructor que tome un ID
	// PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Fecha y hora de envío: %s \n", date);
		report += String.format("Reportado por ID: %s\n", this.id);
		report += String.format("Nombre del paciente: %s\n", patientName);
		report += String.format("Notas: %s \n", notes);
		this.patientNotes.add(report);
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin >= 1000 && pin <= 9999) {
			setPin(pin);
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == getPin()) {
			return true;
		}
		return false;
	}

	// PARA HACER: Setters y Getters

}
