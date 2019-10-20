package org.developer.model;

import java.util.Date;

public class Developer {
	
	private int id;
	private String name;
	private String position;
	private String task;
	private Date dob;
	private String fatherName;
	private String email;
	
	public Developer() {}
	
	public Developer(int id,String name, String position, String task, Date dob, String email) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.task = task;
		this.dob = dob;
		this.email = email;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getPosition() {
		return position;
	}

	
	public void setPosition(String position) {
		this.position = position;
	}

	
	public String getTask() {
		return task;
	}

	
	public void setTask(String task) {
		this.task = task;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	

}
