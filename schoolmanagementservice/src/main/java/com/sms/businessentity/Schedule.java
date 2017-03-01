package com.sms.businessentity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
@XmlRootElement(name = "Schedule")
@JsonRootName(value = "Schedule")
public class Schedule {
	private int id;	
	private String avl;
	
	public Schedule(){}
	
	public Schedule(int id, String avl){
		super();
		this.id = id;
		this.avl = avl;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvl() {
		return avl;
	}
	public void setAvl(String avl) {
		this.avl = avl;
	}
}
