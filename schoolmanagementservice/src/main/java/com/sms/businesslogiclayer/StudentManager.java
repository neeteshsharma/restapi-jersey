package com.sms.businesslogiclayer;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import com.sms.businessentity.Student;
import com.sms.restfulservices.dao.MySqlStudentDAOImpl;
import com.sms.restfulservices.dao.IStudentDao;

public class StudentManager {
	private static StudentManager studentManager = new StudentManager();
	IStudentDao studentDAO;

	private StudentManager() {
	}

	public static StudentManager instance() {
		return studentManager;
	}

	public static IStudentDao getStudentDAO() {
		return new MySqlStudentDAOImpl();
	}

	public Response addStudent(Student student) throws SQLException, Exception {
		studentDAO = StudentManager.getStudentDAO();
		studentDAO.saveStudent(student);
		System.out.println("Add Student Data:	" + student);
		return Response.ok(200).build();
	}

	public Student getStudent(String id) throws Exception {
		studentDAO = StudentManager.getStudentDAO();
		Student data = studentDAO.getStudent(id);
		System.out.println("Data Shows:	" + studentDAO.getStudent(id));
		return data;
	}

	public List<Student> getStudentByName(String name) throws Exception {
		studentDAO = StudentManager.getStudentDAO();
		System.out.println("Data Shows By Name:	" + studentDAO.getStudentByName(name));
		List<Student> data = studentDAO.getStudentByName(name);
		return data;
	}

	public List<Student> getStudentByCity(String city) throws Exception {
		studentDAO = StudentManager.getStudentDAO();
		System.out.println("Data Shows By City:	" + studentDAO.getStudentByCity(city));
		List<Student> data = studentDAO.getStudentByCity(city);
		return data;
	}

	public List<Student> getStudentBySemester(String semester) throws Exception {
		studentDAO = StudentManager.getStudentDAO();
		System.out.println("Data Shows By Semester:	" + studentDAO.getStudentBySemester(semester));
		List<Student> data = studentDAO.getStudentBySemester(semester);
		return data;
	}
}
