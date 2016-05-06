package org.jnit.jdbc;

import java.io.Serializable;

public class PatientInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int pid;
	private String Pname;
	private int pphone;
	private TreatmentInfo treatment;

	public TreatmentInfo getTreatment() {
		return treatment;
	}

	public void setTreatment(TreatmentInfo treatment) {
		this.treatment = treatment;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public int getPphone() {
		return pphone;
	}

	public void setPphone(int pphone) {
		this.pphone = pphone;
	}

}