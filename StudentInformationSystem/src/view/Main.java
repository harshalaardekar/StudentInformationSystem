package view;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dao.StudentDao;
import dao.StudentDaoImpInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		StudentDao dao = new StudentDaoImpInMemory();
		
		Student student1 = new Student("Jofn",LocalDate.of(2000, 12, 12),Qualification.Graduate,"8474839589","John@hotmail.com","Mumbai");
		Student student2 = new Student("Mike", LocalDate.of(2001, 9, 15), Qualification.Master, "1234865123", "mike@lti.com", "Mumbai");
		Student student3 = new Student("Kevin", LocalDate.of(2000, 10, 22), Qualification.Graduate, "123456846", "kevin@lti.com", "Mumbai");
		Student student4 = new Student("Brett", LocalDate.of(2001, 10, 12), Qualification.Intermediate, "9876541230", "brett@lti.com", "Mumbai");

		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);
		
		Course course1 = new Course( "Java", 6, 4000, Qualification.Graduate);
		Course course2 = new Course( "Python", 3, 2000, Qualification.Graduate);
		Course course3 = new Course( "Azure", 8, 8000, Qualification.Master);
		Course course4 = new Course( ".Net", 5, 5000, Qualification.Matric);
		
		//Add courses
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);
		
		
		//registrations
		System.out.println("Eneter student roll no and course applying for : ");
		int rollNo=scanner.nextInt();
		int courseId = scanner.nextInt();
		
		Student stud1 = dao.findStudentByRollNo(rollNo);
		Course c1 = dao.findCourseById(courseId);
		
//		if(stud1 != null) {
//			if(c1 != null) {
//				dao.registration(stud1, c1);
//				System.out.println("Registration successful.");
//			}
//			else {
//				System.out.println("Course not found.");
//			}
//		}
//		else {
//			System.out.println("Student not found.");
//		}
//		
//		System.out.println("View All Registrations : ");
		
		Map<Student, Course> registrations = dao.viewAllRegistrations();
		Set<Map.Entry<Student, Course>> regs = registrations.entrySet();
		
		for(Map.Entry<Student, Course> r:regs){
			Student s = r.getKey();
			Course c= r.getValue();
			System.out.println(s.getRollno()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}
		
		
//		Course c1 = dao.findCourseById(100);
//		Course c2 = dao.findCourseById(101);
//		Course c3 = dao.findCourseById(102);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//DAO Method view all courses
		System.out.println("View All Courses :");
		List<Course> courses = dao.viewAllCourses();
		Iterator<Course> iteratorCourse = courses.iterator();
		while(iteratorCourse.hasNext()) {
			Course course = iteratorCourse.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDuration()+" "+course.getFee()+" "+course.getEligibility());
		}
		
		
		
		//DAO METHODS
				
				System.out.println("View All Students");
				
				List<Student> students = dao.viewAllStudent();
				
				Iterator<Student> iterator=students.iterator();
				while(iterator.hasNext())
				{
					Student student = iterator.next();
					System.out.println(student.getRollno()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo()+" "+Student.getCollegename());
					
				}
				
				//Searching Student
//				Scanner scanner=new Scanner(System.in);
//				int rollNo=scanner.nextInt();
//				
//				Student student=dao.findAStudentByRollNo(rollNo);
//				if(student!=null)
//				{
//					System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail());
//					
//				}
//				else
//				{
//					System.out.println("Student not found");
//				}
				
				
//				//Find Student by roll no
//				System.out.println("Enter Roll No:");
//				int rollNo=scanner.nextInt();
//				
//				Student student=dao.findStudentByRollNo(rollNo);
//				if(student!=null)
//				{
//					System.out.println("Enter Phone No:");
//					String phoneNo = scanner.next();
//					student.setPhoneNo(phoneNo);
//					dao.updateStudentProfile(student);
//				}
//				else
//				{
//					System.out.println("Student not found");
//				}
				
				
				
				
		
	}

}
