package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {
	String addNewStudent(Student student);

	String updateStudentProfile(int rollNo,String address);

	public String registrationDb(Registration registration); 
	Student findStudentByRollNo(int rollNo);

	List<Student> viewAllStudent();
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	Map<Student, Course> viewAllRegistrations();
//	viewRegistrationByRollNo(int rollNo);
	Course findCourseById(int courseID);
	
}
