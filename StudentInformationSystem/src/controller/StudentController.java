package controller;

import java.util.List;
import java.util.Map;

import dao.StudentDao;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {

	StudentDao dao = new StudnetDaoImpDatabase();

	public String addNewStudent(Student student) {
		if (student.getPhoneNo().length() != 10) {

			try {
				throw new PhoneException("Invalid Phone number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
		}
		return dao.addNewStudent(student);
	}

	public String updateStudentProfile(int rollNo,String address) {
		return dao.updateStudentProfile(rollNo,address);

	}

	public String registrationDb(Registration registration) {
		String message="";
		Student student=dao.findStudentByRollNo(registration.getRollNo());
		Course course=dao.findCourseById(registration.getCourseId());
		if(student!=null) {
			if(course!=null) {
				if(student.getQualification().equals(course.getEligibility())) {
					message=dao.registrationDb(registration);
				}
				else {
					message="You are not eligible.";
				}
			}
			else {
				message="Course not found.";
			}
		}
		else {
			message="Student does not exist.";
		}
		return message;
	}

	public Student findStudentByRollNo(int rollNo) {
		return dao.findStudentByRollNo(rollNo);
	}

	public List<Student> viewAllStudent() {
		return dao.viewAllStudent();
	}

	public String addNewCourse(Course course) {
		return dao.addNewCourse(course);
	}

	public List<Course> viewAllCourses() {
		return dao.viewAllCourses();
	}

	public Map<Student, Course> viewAllRegistrations() {
		return null;
	}

	public Course findCourseById(int courseID) {
		return dao.findCourseById(courseID);
	}

}
