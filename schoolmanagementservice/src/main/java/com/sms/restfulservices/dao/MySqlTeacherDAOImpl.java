package com.sms.restfulservices.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.businessentity.Schedule;
import com.sms.businessentity.Teacher;
import com.sms.restfulservices.util.Database;

/**
 * Created by Administrator on 12/10/2015.
 */
public class MySqlTeacherDAOImpl implements ITeacherDao {

	@Override
	public void saveTeacher(Teacher teacher) throws SQLException, Exception {
		String randomTid = String.valueOf((int) (Math.random() * 9000) + 1000);
		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("insert into teacher(name, subject, exp, Tid) values (" + "'" + teacher.getName()
						+ "'," + "'" + teacher.getSubject() + "'," + "'" + teacher.getExp() + "'," + "'" + randomTid
						+ "'" + ")");
		int rs = stmt.executeUpdate();
		Database.getConnection()
				.prepareStatement("insert into schedule (tid,avl) values ((select id from teacher where name=" + "'"
						+ teacher.getName() + "' AND Tid=" + "'" + randomTid + "')," + "'" + teacher.getAvailability()
						+ "')")
				.executeUpdate();

	}

	@Override
	public Teacher getTeacher(String id) throws SQLException, Exception {
		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM teacher where id=" + "'" + id + "'");
		ArrayList<Teacher> teacherData = new ArrayList<Teacher>();
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Teacher teacherObj = new Teacher();

				teacherObj.setId(rs.getInt("id"));
				teacherObj.setName(rs.getString("name"));
				teacherObj.setSubject(rs.getString("subject"));
				teacherObj.setExp(rs.getString("exp"));
				// teacherObj.setAvailability(rs.getString("availability"));
				teacherData.add(teacherObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherData.get(0);
	}

	@Override
	public List<Teacher> getTeacherByName(String name) throws SQLException, Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM teacher where name=" + "'" + name + "'");
		return retrieveTeacherData(stmt);
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) throws SQLException, Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM teacher where subject=" + "'" + subject + "'");
		return retrieveTeacherData(stmt);
	}

	@Override
	public List<Teacher> getTeacherByExp(String exp) throws SQLException, Exception {

		PreparedStatement stmt = Database.getConnection()
				.prepareStatement("SELECT * FROM teacher where exp=" + "'" + exp + "'");
		return retrieveTeacherData(stmt);
	}

	@Override
	public List<Teacher> getTeacherByAvailability(String availability) throws SQLException, Exception {
		ArrayList<Teacher> teacherData = new ArrayList<Teacher>();
		PreparedStatement stmt = Database.getConnection().prepareStatement(
				"SELECT * FROM teacher INNER JOIN schedule ON teacher.id=schedule.tid where schedule.avl=" + "'"
						+ availability + "'");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Teacher teacherObj = new Teacher();
				Schedule sch = new Schedule();
				sch.setAvl(rs.getString("avl"));
				teacherObj.setId(rs.getInt("id"));
				teacherObj.setName(rs.getString("name"));
				teacherObj.setSubject(rs.getString("subject"));
				teacherObj.setExp(rs.getString("exp"));
				teacherObj.setSchedule(sch);
				teacherData.add(teacherObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherData;
	}

	private List<Teacher> retrieveTeacherData(PreparedStatement stmt) throws SQLException {
		ArrayList<Teacher> teacherData = new ArrayList<Teacher>();
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Teacher teacherObj = new Teacher();

				teacherObj.setId(rs.getInt("id"));
				teacherObj.setName(rs.getString("name"));
				teacherObj.setSubject(rs.getString("subject"));
				teacherObj.setExp(rs.getString("exp"));
				// teacherObj.setAvailability(rs.getString("availability"));
				teacherData.add(teacherObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherData;
	}

	@Override
	public void updateAvailability(String tid, String avl) throws SQLException, Exception {
		PreparedStatement stmt = Database.getConnection().prepareStatement("update schedule set avl = " + "'" + avl
				+ "' where tid = (select id from teacher where Tid=" + "'" + tid + "'" + ")");
		stmt.executeUpdate();
	}

}
