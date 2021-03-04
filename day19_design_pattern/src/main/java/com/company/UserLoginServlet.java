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
import com.mysql.jdbc.Driver;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
    ServletException, IOException 
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ArrayList<Employee> employees = getUserByLogin(username, password);

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
    }

    protected ArrayList<Employee> getUserByLogin(String usernameFromEvilUser, String passwordFromEvilUser) {   
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp2", "root", "");
            
            String myOwnInCompleteSQL = "SELECT * FROM employee_users WHERE username = '" + usernameFromEvilUser + "' AND password = '"+passwordFromEvilUser + "'";
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(myOwnInCompleteSQL);
            
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

