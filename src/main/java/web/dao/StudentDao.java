package web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.vo.Student;
/**
 * 
 * This StudentDao class is used to do the CRUD Operations using DAO design pattern
 *
 */
public class StudentDao {
	
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost:3306/sample";
	private String user = "root";
	private String password = "root";
	
	private Connection conn = null;
	
	private Connection getConnection() throws SQLException{
		if(conn == null) {
			System.out.println("Connection is created ");
			try {
				Class.forName(driverName);
			}catch(ClassNotFoundException e) {
				System.out.println("Please check does driver exist or not");
			}
		}
		conn = DriverManager.getConnection(jdbc_url, user, password);
		return conn;
	}
	public List<Student> getAllStudents(){
		List<Student> sts = new ArrayList<Student>();
		
		//Connecting to the database
		try(
		Statement stmt = getConnection().createStatement();
		//Run the query
		ResultSet rs = stmt.executeQuery("select * from student");){
		while(rs.next()) {
			int stu_id = rs.getInt("stud_id");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			Student s = new Student(stu_id,firstName,lastName);
			sts.add(s);
		}
	}
		catch(SQLException ex) {
			System.out.println("Error message "+ex.getMessage());
		}
		return sts;
	}
	
	public void saveStudent(Student st){}
	
	public void updateStudent(Student st) {}
	
	public void deleteStudent(int stu_id) {}
	
	public Student getStudent(int stu_id) {
		return null;
	}
	

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		List<Student> sts = dao.getAllStudents();
		for(Student st:sts) {
			System.out.println(st.getFirstName());
		}
		
	}

}
