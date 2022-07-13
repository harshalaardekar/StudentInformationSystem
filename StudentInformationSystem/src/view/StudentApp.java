package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentApp {
	public static void main(String args[]) {
		int rollNo;
		String name;
		String dateOfBirth; // 04/09/1998
		String phoneNumber;
		String email;
		String address;
		Qualification qualification;
		Student student;
		String message;

		StudentController controller = new StudentController();

		Scanner sc = new Scanner(System.in);
		String con = "y";
		do {

			System.out.println("1. Student \n2. Admin \n3.Exit");
			int userType = sc.nextInt();

			if (userType == 1) {
				String choice = "y";
				do {
					System.out.println(
							"1.Sign up \n2.Update Profile \n3.View All courses \n4.Register For A Course \n5.Find Course \n6.Sign Out");
					int option = sc.nextInt();

					switch (option) {
					case 1:
						System.out.println("Enter name,date of birth(mm/dd/YYYY),phone number,email and address : ");
						name = sc.next();

						dateOfBirth = sc.next(); // 04/09/1998
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dob = LocalDate.parse(dateOfBirth, formatter);

						phoneNumber = sc.next();
						email = sc.next();
						address = sc.next();

						System.out.println("1. Master 2. Graduate 3. Intermediate 4. Matric");
						int q = sc.nextInt();
						qualification = null;
						if (q == 1)
							qualification = Qualification.Master;
						if (q == 2)
							qualification = Qualification.Graduate;
						if (q == 3)
							qualification = Qualification.Intermediate;
						if (q == 4)
							qualification = Qualification.Matric;

						student = new Student(name, dob, qualification, phoneNumber, email, address);
						message = controller.addNewStudent(student);
						System.out.println(message);
						break;

					case 2:

						System.out.println("Enter Roll Number where you want to update data: ");
						rollNo = sc.nextInt();

						Student st = controller.findStudentByRollNo(rollNo);
						if (st != null) {
							System.out.println("Enter address : ");

							address = sc.next();
							sc.nextLine();

							message = controller.updateStudentProfile(rollNo, address);
							System.out.println(message);
						} else {
							System.out.println("Invalid Roll No");
						}

						break;

					case 3:

						List<Course> courses = controller.viewAllCourses();
						Iterator<Course> itcrc = courses.iterator();

						while (itcrc.hasNext()) {
							Course c = itcrc.next();

							System.out.println(c.getCourseId() + " " + c.getCourseName() + " " + c.getDuration() + " "
									+ c.getFee() + " " + c.getEligibility());

						}
						break;

					case 4:
						
						System.out.println("Enter your rollno and course you want to register for");
						rollNo=sc.nextInt();
						int courseId=sc.nextInt();
						String regDateString=sc.next();
						DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate regDate=LocalDate.parse(regDateString, formatter2);
						
						Registration registration=new Registration(regDate, courseId, rollNo);
						
						message= controller.registrationDb(registration);
						System.out.println(message);
						break;
//						
//						System.out.println("Enter your rollno and course you want to register for");
//						rollNo=sc.nextInt();
//						int courseId=sc.nextInt();
//						String regDateString=sc.next();
//						DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy");
//						LocalDate regDate=LocalDate.parse(regDateString, formatter2);
//						
//						Registration registration=new Registration(regDate, courseId, rollNo);
//						
//						message= controller.registrationDb(registration);
//						System.out.println(message);
//						break;

					case 5:
						System.out.println("Enter CourseId : ");
						int cid = sc.nextInt();
						Course c = controller.findCourseById(cid);
						if (c != null) {
							System.out.println(c.getCourseId() + " " + c.getCourseName() + " " + c.getDuration() + " "
									+ c.getFee() + " " + c.getEligibility());
						} else {
							System.out.println("No record found");
						}
						break;

					case 6:

					}

					System.out.println("Continue?");
					choice = sc.next();
				} while (choice.equalsIgnoreCase("y"));
			}

			else if (userType == 2) {
				System.out.println(
						"1. View All Users \n2.Find Student \n3.Add new Course \n4.View All Courses \n5.View All Registrations");
				int option = sc.nextInt();

				switch (option) {
				case 1:
					List<Student> students = controller.viewAllStudent();
					Iterator<Student> iterator = students.iterator();

					while (iterator.hasNext()) {
						Student st = iterator.next();
						System.out.println(st.getRollno() + " " + st.getName() + " " + st.getDateOfBirth() + " "
								+ st.getQualification());
					}
					break;

				case 2:
					System.out.println("Enter Roll No :");
					rollNo = sc.nextInt();

					Student st = controller.findStudentByRollNo(rollNo);
					if (st != null) {
						System.out.println(st.getRollno() + " " + st.getName() + " " + st.getQualification() + " "
								+ st.getAddress());
					} else {
						System.out.println("No record found");
					}
					break;
				case 3:
					System.out.println("Enter course name,duration,fee");
					String cname = sc.next();
					int duration = sc.nextInt();
					double fee = sc.nextDouble();

					System.out.println("1. Master 2. Graduate 3. Intermediate 4. Matric");
					int q = sc.nextInt();
					Qualification eligibility = null;
					if (q == 1)
						eligibility = Qualification.Master;
					if (q == 2)
						eligibility = Qualification.Graduate;
					if (q == 3)
						eligibility = Qualification.Intermediate;
					if (q == 4)
						eligibility = Qualification.Matric;

					Course course = new Course(cname, duration, fee, eligibility);
					message = controller.addNewCourse(course);
					System.out.println(message);

					break;

				case 4:

				}
			} else if (userType == 3) {
				break;
			} else {
				System.out.println("Invalid Choice.");
			}
			System.out.println("Continue ?");
			con = sc.next();
		} while (con.equalsIgnoreCase("y"));

	}
}
