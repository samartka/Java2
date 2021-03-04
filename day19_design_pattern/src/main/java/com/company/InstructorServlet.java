package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Driver;

public class InstructorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Employee> employee = getUserById("1001");
        String jsonOutput = "";
        try {
            jsonOutput = objectMapper.writeValueAsString(employee);
            System.out.println(jsonOutput);
        } catch (JsonProcessingException ex) {
            System.out.println("There's something wrong with writeValueAsString: " + 
            ex.getMessage());
        }
         
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(jsonOutput);
        outputStream.flush();
        outputStream.close();
    }

    protected ArrayList<Employee> getUserById(String idFromGet) {   
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp2", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee_users WHERE id = ?");
            
            //Bind values into the parameters.
            statement.setString(1, idFromGet);  // เซ็ตค่า idFromGet ไปแทนที่ ? ที่เว้นไว้ ใน SQL Statement
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Employee employee = new Employee();
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String company = resultSet.getString("company");
                int salary = resultSet.getInt("salary");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                employee.setId(id);
                employee.setFirstname(firstname);
                employee.setLastname(lastname);
                employee.setCompany(company);
                employee.setSalary(salary);
                employee.setUsername(username);
                employee.setPassword(password);
                employees.add(employee);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

