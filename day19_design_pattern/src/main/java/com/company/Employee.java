package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private int salary;
    private String company;
    private String username;
    private String password;
    private MyDb dbConnection;

    public Employee() {

    }

    public Employee(int id, String firstname, String lastname, int salary, String company) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.company = company;
    }

    public Employee(ResultSet resultSet) {

    }

    public Employee(MyDb dbConnection) {
        this.dbConnection = dbConnection; // Constructor Injection
    }

    public void SetDbConnection(MyDb newConnection) {
        this.dbConnection = newConnection; // Property Injection
    }
    
    public ArrayList<Employee> employeeIdGet(String id) {
        String sql = "SELECT * FROM employee_users WHERE id = ?";
        String[] bindValues = new String[]{id};
        // Use dbConnection
        ArrayList<Employee> employees = dbConnection.employeeQueryGet(sql, bindValues);

        return employees;
    }

    public MyDb GetDbConnection() {
        return dbConnection;
    }

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}