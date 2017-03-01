package com.sms.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sms.businessentity.Schedule;
import com.sms.businessentity.Student;
import com.sms.businessentity.Teacher;
import com.sms.businesslogiclayer.StudentManager;
import com.sms.businesslogiclayer.TeacherManager;
import com.sms.restfulservices.dao.IStudentDao;

/**
 * Created by Administrator on 12/10/2015.
 */
@Produces({ "application/xml", "application/json" })
@Path("/smsresources")
public class Services  {
	IStudentDao studentDAO;

	@POST
	@Path("students/")
	@Produces("text/plain")
	public Response addStudent(Student student) throws SQLException, Exception {
		return StudentManager.instance().addStudent(student);
	}

	@GET
	@Path("studentsdatabyid/{id}/")
	@Produces("application/json")
	public Student getStudent(@PathParam("id") String id) throws Exception {
		return StudentManager.instance().getStudent(id);
	}

	@GET
	@Path("studentsdatabyname/{name}/")
	@Produces("application/json")
	public List<Student> getStudentByName(@PathParam("name") String name) throws Exception {
		return StudentManager.instance().getStudentByName(name);
	}

	@GET
	@Path("studentsdatabycity/{city}/")
	@Produces("application/json")
	public List<Student> getStudentByCity(@PathParam("city") String city) throws Exception {
		return StudentManager.instance().getStudentByCity(city);
	}

	@GET
	@Path("studentsdatabysemester/{semester}/")
	@Produces("application/json")
	public List<Student> getStudentBySemester(@PathParam("semester") String semester) throws Exception {
		return StudentManager.instance().getStudentBySemester(semester);
	}

	@POST
	@Path("teachers/")
	@Produces("text/plain")
	public Response addTeacher(Teacher teacher) throws SQLException, Exception {
		return TeacherManager.instance().addTeacher(teacher);
	}

	@GET
	@Path("teachersdatabyid/{id}/")
	@Produces("application/json")
	public Teacher getTeacher(@PathParam("id") String id) throws Exception {
		return TeacherManager.instance().getTeacher(id);
	}

	@GET
	@Path("teachersdatabyname/{name}/")
	@Produces("application/json")
	public List<Teacher> getTeacherByName(@PathParam("name") String name) throws Exception {
		return TeacherManager.instance().getTeacherByName(name);
	}

	@GET
	@Path("teachersdatabysubject/{subject}/")
	@Produces("application/json")
	public List<Teacher> getTeacherBySubject(@PathParam("subject") String subject) throws Exception {
		return TeacherManager.instance().getTeacherBySubject(subject);
	}

	@GET
	@Path("teachersdatabyexp/{exp}/")
	@Produces("application/json")
	public List<Teacher> getTeacherByExp(@PathParam("exp") String exp) throws Exception {
		return TeacherManager.instance().getTeacherByExp(exp);
	}

	@GET
	@Path("teachersdatabyavailability/{availability}/")
	@Produces("application/json")
	public List<Teacher> getTeacherByAvailability(@PathParam("availability") String availability) throws Exception {
		return TeacherManager.instance().getTeacherByAvailability(availability);
	}

	@PUT
	@Path("updateavailability/")
	@Produces("text/plain")
	public Response updateAvailability(Schedule sch) throws Exception {
		return TeacherManager.instance().updateAvailability(sch);
	}

}
