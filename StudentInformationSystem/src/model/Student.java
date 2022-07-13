package model;

import java.time.LocalDate;

public class Student {
	private int rollno;
	private String name;
	private LocalDate dateOfBirth;
	private Qualification qualification;
	private String phoneNo;
	private String email;
	private String address;
	private static final String collegeName;
//	private static int rollNoGenerator=0;
	
	static {
		collegeName="LTI college";
	}

	public Student() {}

	public Student(String name, LocalDate dateOfBirth, Qualification qualification, String phoneNo, String email,
			String address) {
		super();
//		this.rollno=++rollNoGenerator;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.qualification = qualification;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public static String getCollegename() {
		return collegeName;
	}

}
