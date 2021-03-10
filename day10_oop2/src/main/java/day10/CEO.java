package day10;

import day10.my_interface.IWebsiteCreator;

public class CEO extends Employee {   
    public CEO(String firstnameInput, String lastnameInput, int salaryInput) {
        super(firstnameInput, lastnameInput, salaryInput);
    }
    @Override
    public int getSalary() {
        return super.getSalary() * 2;
    }
    
    public void hello() {
        System.out.println("Hi, nice to meet you. "+this.firstname+"!");
    }
    public void orderWebsite( IWebsiteCreator creator) {
    	creator.createWebsite("some template", "Codecamp Codecamp3");
    }
}
   
   