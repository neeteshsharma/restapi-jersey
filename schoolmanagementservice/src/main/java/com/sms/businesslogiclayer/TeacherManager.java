package com.sms.businesslogiclayer;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import com.sms.businessentity.Schedule;
import com.sms.businessentity.Teacher;
import com.sms.restfulservices.dao.ITeacherDao;
import com.sms.restfulservices.dao.MySqlTeacherDAOImpl;


public class TeacherManager {
	private static TeacherManager teacherManager = new TeacherManager();
	ITeacherDao teacherDAO;

	private TeacherManager() {
	}

	public static TeacherManager instance() {
		return teacherManager;

	}

	public static ITeacherDao getTeacherDAO() {
		return new MySqlTeacherDAOImpl();
	}

	public Response addTeacher(Teacher teacher) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		teacherDAO.saveTeacher(teacher);
		System.out.println("Add Teacher Data:	" + teacher);
		return Response.ok(200).build();
	}

	public Teacher getTeacher(String id) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		System.out.println("Data Shows:	" + teacherDAO.getTeacher(id));
		Teacher data = teacherDAO.getTeacher(id);
		return data;
	}

	public List<Teacher> getTeacherByName(String name) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		System.out.println("Data Shows:	" + teacherDAO.getTeacherByName(name));
		List<Teacher> data = teacherDAO.getTeacherByName(name);
		return data;
	}

	public List<Teacher> getTeacherBySubject(String subject) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		System.out.println("Data Shows:	" + teacherDAO.getTeacherBySubject(subject));
		List<Teacher> data = teacherDAO.getTeacherBySubject(subject);
		return data;
	}

	public List<Teacher> getTeacherByExp(String exp) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		System.out.println("Data Shows:	" + teacherDAO.getTeacherByExp(exp));
		List<Teacher> data = teacherDAO.getTeacherByExp(exp);
		return data;
	}

	public List<Teacher> getTeacherByAvailability(String availability) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		System.out.println("Data Shows:	" + teacherDAO.getTeacherByAvailability(availability));
		List<Teacher> data = teacherDAO.getTeacherByAvailability(availability);
		return data;
	}

	public Response updateAvailability(Schedule schedule) throws SQLException, Exception {
		teacherDAO = TeacherManager.getTeacherDAO();
		teacherDAO.updateAvailability(String.valueOf(schedule.getId()), schedule.getAvl());
		return Response.ok(200).build();
	}

}