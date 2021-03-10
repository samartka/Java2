package day10;
import java.util.ArrayList;
import day10.my_interface.IWebsiteCreator;


public class Day10 {

	public static void main(String[] args) {

    	CEO myCEO = new CEO("BossName", "BossLastName", 500000);
    	Employee myEmployee = new Employee("Minion", "Kung", 12000);
    	Programmer myProgrammer = new Programmer("Bill", "Gates", 1000000);

    	Employee ceo = new CEO(" Captain", " Marvel", 30000);
    	CEO ceo2 = (CEO) ceo;
    	
    	ArrayList<Employee> myList = new ArrayList<>();
    	myList.add(ceo2);
    	myList.add(myEmployee);
    	myList.add(myProgrammer);
    	CEO ceo3 = (CEO) myList.get(0);
    	Employee myEmploye2 = myList.get(1);
    	Programmer myProgprog2 = (Programmer) myList.get(2);

    	ceo3.hello(); 
    	myEmploye2.hello();
    	myProgprog2.hello();    
    	
    	
    	IWebsiteCreator employeeFromInterface = new Programmer("Dang","Red",102000);
    	Programmer programmer02 = (Programmer) employeeFromInterface;
    	AI alphaGo = new AI("alphaGo", "Java");
    	IWebsiteCreator alphaGo2 = alphaGo;    	

    	ceo2.orderWebsite(employeeFromInterface);
    	ceo2.orderWebsite(programmer02);
    	ceo2.orderWebsite(alphaGo);
    	ceo2.orderWebsite(alphaGo2);    	
    	
    	
    	
    	String[] skills =  new String[] {"SQL",".NET","JAVA"};
    	Programmer myProgrammer2 = new Programmer("PPP", "QQQ", 50000,skills);
    	System.out.println("This programmer's salary is " + myProgrammer.getSalary());
    	System.out.println("This programmer's salary is " + myProgrammer2.compSkill[1]);
    	
    }
}