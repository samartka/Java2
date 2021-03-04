package com.company;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class MyDb {
    private Connection connection;
    private static MyDb instance = null; 

    public static MyDb getInstance() 
    { 
        if (instance == null) 
            instance = new MyDb("localhost:3306", "root", "", "codecamp2"); // Default Database
  
        return instance; 
    } 

    public MyDb(String host, String username, String password, String database) {  // Custom Database
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password); 
        } catch (SQLException ex) {
            System.out.println("Connection error: " + ex.toString());
        }
    }

    public ArrayList<Employee> employeeQueryGet(String sql, String[] bindValues) {
        ArrayList<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            for (int i=0; i < bindValues.length; i++) {
                statement.setString(i+1, bindValues[i]);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet);
                allEmployees.add(employee);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Query Error : "+sql);
            System.out.println("Exception: "+ex.toString());
        }

        return allEmployees;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Cannot Close Connection" + ex.toString());
        }
    }

}