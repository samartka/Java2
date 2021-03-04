package com.company;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Application {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);

        // url start from http://localhost:8080/
        tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        tomcat.getConnector();
        tomcat.start();
    }
}
