package com.sms.restfulservices.dao;

import com.sms.businessentity.Student;
import com.sms.restfulservices.util.Database;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Administrator on 12/10/2015.
 */
public class MySqlStudentDAOImpl implements IStudentDao {
	PreparedStatement ps = null;

	@Override
	public Student getStudent(String id) throws Exception {
		Student studentObj = new Student();
		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM student where id=" + "'" + id + "'");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {

				studentObj.setId(rs.getInt("id"));
				studentObj.setName(rs.getString("name"));
				studentObj.setCity(rs.getString("city"));
				studentObj.setSemester(rs.getString("semester"));
				// studentList.add(studentObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentObj;
	}

	@Override
	public void saveStudent(Student student) throws SQLException, Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("insert into student(name, city, semester) values (" + "'" + student.getName() + "',"
						+ "'" + student.getCity() + "'," + "'" + student.getSemester() + "'" + ")");
		int rs = stmt.executeUpdate();

	}

	@Override
	public ArrayList<Student> getStudentByName(String name) throws Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM student where name=" + "'" + name + "'");
		return retrieveData(stmt);

	}

	@Override
	public ArrayList<Student> getStudentByCity(String city) throws Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM student where city=" + "'" + city + "'");
		return retrieveData(stmt);
	}

	@Override
	public ArrayList<Student> getStudentBySemester(String semester) throws Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM student where semester=" + "'" + semester + "'");
		return retrieveData(stmt);
	}

	private ArrayList<Student> retrieveData(PreparedStatement stmt) throws SQLException {
		ArrayList<Student> studentData = new ArrayList<Student>();
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Student studentObj = new Student();

				studentObj.setId(rs.getInt("id"));
				studentObj.setName(rs.getString("name"));
				studentObj.setCity(rs.getString("city"));
				studentObj.setSemester(rs.getString("semester"));
				studentData.add(studentObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentData;
	}
}
