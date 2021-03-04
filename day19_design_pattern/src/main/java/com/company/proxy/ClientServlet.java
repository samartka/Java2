package com.company.proxy;

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

public class ClientServlet extends HttpServlet {
    ProxyInternet internet = new ProxyInternet();
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serverHost = req.getParameter("myTestUrl");
        String result = "";
        try {
            result = internet.connectTo(serverHost);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        req.setAttribute("result", result);
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}
   
   