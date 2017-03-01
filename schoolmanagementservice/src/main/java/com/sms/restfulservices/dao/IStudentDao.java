package com.sms.restfulservices.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.sms.businessentity.Student;

/**
 * Created by Administrator on 12/10/2015.
 */
public interface IStudentDao {

    /*public Response addStudent(Student student);*/

    Student getStudent(String id) throws Exception;
    
    ArrayList<Student> getStudentByName(String name) throws Exception;

	public void saveStudent(Student student) throws SQLException, Exception;

	ArrayList<Student> getStudentByCity(String city) throws Exception;

	ArrayList<Student> getStudentBySemester(String semester) throws Exception;

}
