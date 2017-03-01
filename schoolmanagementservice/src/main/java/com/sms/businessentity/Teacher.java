package com.sms.businessentity;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Created by Administrator on 12/10/2015.
 */
@XmlRootElement(name = "Teacher")
@JsonRootName(value = "Teacher")
public class Teacher {
	private int id;
	private String name;
    private String subject;
    private String exp;
    private String availability;
    private String Tid;
	private Schedule schedule;
    
public Teacher(){

}
public Teacher(int id, String name, String subject, String exp, String availability, Schedule schedule){
    super();
    this.id = id;
    this.name = name;
    this.subject = subject;
    this.exp = exp;
    this.availability = availability;
    this.schedule = schedule;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
public Schedule getSchedule() {
	return schedule;
}
public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}

public String getTid() {
		return Tid;
	}
public void setTid(String tid) {
		Tid = tid;
	}

   
    @Override
    public String toString()
    {
        return " [id=" + id + ", name=" + name + ", subject=" + subject
                + ", exp=" + exp + ", availability=" + availability + ", schedule" + schedule + "]";
    }
}
