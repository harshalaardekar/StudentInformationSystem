package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


import model.Course;
import model.Registration;
import model.Student;

public class StudentDaoImpInMemory implements StudentDao {

	public static List<Student> students = new ArrayList<Student>();
	public static Set<Course> courses = new HashSet<Course>();	
	public static Map<Student, Course> registrations= new HashMap<Student,Course>();
	
	@Override
	public String addNewStudent(Student student) {
		// TODO Auto-generated method stub
		students.add(student);
		return "";
	}

	@Override
	public String updateStudentProfile(int rollNo,String address) {
		// TODO Auto-generated method stub
//		Student student1 = findStudentByRollNo(student.getRollno());
//		int index;
//		index = students.indexOf(student1);
//		students.set(index, student);
		return "";
	}

	@Override
	public String registrationDb(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return students.stream()
				.filter(st -> st.getRollno() == rollNo)
				.findFirst()
//				.get();
				.orElse(null);
	}

	@Override
	public List<Student> viewAllStudent() {
		// TODO Auto-generated method stub
		return students.stream().collect(Collectors.toList());
	}

	@Override
	public String addNewCourse(Course course) {
		// TODO Auto-generated method stub
		courses.add(course);
		return null;
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return courses.stream().collect(Collectors.toList());
	}

	@Override
	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return registrations;
	}

	@Override
	public Course findCourseById(int courseID) {
		// TODO Auto-generated method stub
		return courses.stream()
				.filter(c->c.getCourseId() == courseID)
				.findAny()
				.orElse(null);
	}

	


}
