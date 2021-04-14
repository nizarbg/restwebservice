package org.example.model;

import java.util.Date;

public class Employe {
    private Integer id;
    private String firstname;
    private String lastname;
    private String address;
    private double salary;
    private Date hiredate;

    public Employe() {
        super();
    }

    public Employe(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String adress) {
        this.address = adress;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getHireDate() {
        return hiredate;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}

