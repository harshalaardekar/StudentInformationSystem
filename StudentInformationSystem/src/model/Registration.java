package model;

import java.time.LocalDate;

public class Registration {
	private int registrationNo;
	private LocalDate registrationDate;
	private int courseId;
	private int rollNo;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	
	public Registration(LocalDate registrationDate, int courseId, int rollNo) {
		super();
//		this.registrationNo = registrationNo;
		this.registrationDate = registrationDate;
		this.courseId = courseId;
		this.rollNo = rollNo;
	}
	public int getRegistrationNo() {
		return registrationNo;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	
}
