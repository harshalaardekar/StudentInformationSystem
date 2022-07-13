package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import connection.OracleConnection;
import dao.StudentDao;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudnetDaoImpDatabase implements StudentDao {

	Connection conn;
	PreparedStatement ps;
	
	
	public StudnetDaoImpDatabase() {
		conn=OracleConnection.getConnection();
	}
	
	@Override
	public String addNewStudent(Student student) {
		String sql = "insert into tbl_students values (seq_stud.nextVal,?,?,?,?,?,?)";
		int count = 0;
		String message = "";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setDate(2, Date.valueOf(student.getDateOfBirth()));
			ps.setString(3, student.getQualification().name());
			ps.setString(4, student.getPhoneNo());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getAddress());
//			System.out.println(count);
			count = ps.executeUpdate();
			if(count > 0) {
				message = "New Student Added Successfully";
			}
			else {
				message = "Error Occured";
			}
			
		}catch (Exception e) {
//			System.out.println("end");
			e.printStackTrace();
		}
		return message;
	}


	@Override
	public String updateStudentProfile(int rollNo,String address) {
		
		String sql = "update tbl_students set address=? where rollno=?";
		int count;
		String message = "";
		
		try {

			ps=conn.prepareStatement(sql);
			
			ps.setString(1, address);
			ps.setInt(2, rollNo);
			
			count = ps.executeUpdate();
			
			
			if(count > 0) {  
				message = "Details Updated Successfully";
			}
			else{
				message = "Something went wrong";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}

	@Override
	public String registrationDb(Registration registration) {
		String sql = "insert into tbl_registration values (seq_reg.nextval,?,?,?)";
		String message="";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1,Date.valueOf(registration.getRegistrationDate()));
			ps.setInt(2, registration.getRollNo());
			ps.setInt(3,registration.getCourseId());
			
			int count = ps.executeUpdate();
			System.out.println("c : "+count);
			message = count > 0 ? "Registration Successful" : "Something went wrong";
			
			return message;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Course findCourseById(int courseID) {
		
		String sql="select * from tbl_courses where courseId=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, courseID);
			ResultSet rs = ps.executeQuery();
			Course course =null;
			
			if(rs.next()) {
				course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDuration(rs.getInt(3));
				course.setFee(rs.getDouble(4));
				course.setEligibility(Qualification.valueOf(rs.getString(5)));
			}
			return course;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Student findStudentByRollNo(int rollNo) {
		String sql = "select * from tbl_students where rollno = ?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, rollNo);
			
			ResultSet rs = null;
			rs=ps.executeQuery();
			Student st = null;
			
			if(rs.next()) {
				st = new Student();
				st.setRollno(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setDateOfBirth(rs.getDate(3).toLocalDate());
				st.setQualification(Qualification.valueOf(rs.getString(4)));
				st.setPhoneNo(rs.getString(5));
				st.setEmail(rs.getString(6));
				st.setAddress(rs.getString(7));
				
			}
			
			return st;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public List<Student> viewAllStudent() {
		List<Student> students = new ArrayList<Student>();
		
		String sql = "select * from tbl_students";
		ResultSet rs =null;
		
		try {
		ps=conn.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		Student st=null;
		
		while(rs.next()) {
			st=new Student();
			st.setRollno(rs.getInt(1));
			st.setName(rs.getString(2));
			st.setDateOfBirth(rs.getDate(3).toLocalDate());
			st.setQualification(Qualification.valueOf(rs.getString(4)));
			st.setPhoneNo(rs.getString(5));
			st.setEmail(rs.getString(6));
			st.setAddress(rs.getString(7));
			students.add(st);
		}
		return students;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public String addNewCourse(Course course) {
		String sql="insert into tbl_courses values(seq_crs.nextVal,?,?,?,?)";
		String message = "";
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getDuration());
			ps.setDouble(3, course.getFee());
			ps.setString(4, course.getEligibility().name());
			
			int count= ps.executeUpdate();
			
			if(count>0) {
				message="Course Added Successfully";
			}
			else {
				message="Error Occured";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;

	}

	@Override
	public List<Course> viewAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		String sql = "select * from tbl_courses";
		ResultSet rs = null;
		
		
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Course course=new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDuration(rs.getInt(3));
				course.setFee(rs.getDouble(4));
				course.setEligibility(Qualification.valueOf(rs.getString(5)));
				
				courses.add(course);
			}
			return courses;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
