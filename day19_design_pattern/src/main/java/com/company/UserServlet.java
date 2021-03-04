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

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
    ServletException, IOException 
    {
        String idFromGet = req.getParameter("id");
        //ArrayList<Employee> employees = getUserById(id);

        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codecamp2", "root", "");
            Statement statement = connection.createStatement();
       	    ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_users WHERE id="+idFromGet);
          
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

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
    }

    // protected ArrayList<Employee> getUserById(String idFromGet) {   
        

    //     return employees;
    // }
}

