package org.jnit.jdbc;

import java.io.Serializable;

public class TreatmentInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int t_id;
	private String type;
	private String status;
	private PatientInfo patient;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PatientInfo getPatient() {
		return patient;
	}

	public void setPatient(PatientInfo patient) {
		this.patient = patient;
	}
}
