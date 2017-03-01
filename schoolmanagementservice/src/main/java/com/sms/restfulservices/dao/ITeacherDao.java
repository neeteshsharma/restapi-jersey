package com.sms.restfulservices.dao;

import java.sql.SQLException;
import java.util.List;

import com.sms.businessentity.Student;
import com.sms.businessentity.Teacher;

/**
 * Created by Administrator on 12/10/2015.
 */
public interface ITeacherDao {
	public void saveTeacher(Teacher teacher) throws SQLException, Exception;

	public Teacher getTeacher(String id) throws SQLException, Exception;

	public List<Teacher> getTeacherByName(String name) throws SQLException, Exception;

	public List<Teacher> getTeacherBySubject(String subject) throws SQLException, Exception;

	public List<Teacher> getTeacherByExp(String exp) throws SQLException, Exception;

	public List<Teacher> getTeacherByAvailability(String availability) throws SQLException, Exception;

	public void updateAvailability(String tid, String avl) throws SQLException, Exception;;
}
