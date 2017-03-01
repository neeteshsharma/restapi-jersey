package com.sms.businessentity;

import javax.xml.bind.annotation.XmlRootElement;


import org.codehaus.jackson.map.annotate.JsonRootName;



/**
 * Created by Administrator on 12/10/2015.
 */
@XmlRootElement(name = "Student")
@JsonRootName(value = "Student")
public class Student {
    private int id;
    private String name;
    private String city;
    private String semester;

    public Student()
    {

    }

    public Student(int id, String name, String city, String semester)
    {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.semester = semester;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString()
    {
        return " [id=" + id + ", name=" + name + ", city=" + city
                + ", semester=" + semester + "]";
    }
}
