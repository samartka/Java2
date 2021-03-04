package day10;

public class Day10 {

    public static void main(String[] args) {

    	CEO myCEO = new CEO("BossName", "BossLastName", 500000);
    	Employee myEmployee = new Employee("Minion", "Kung", 12000);
    	Programmer myProgrammer = new Programmer("Bill", "Gates", 1000000);

    	String[] skills =  new String[] {"SQL",".NET","JAVA"};
    	Programmer myProgrammer2 = new Programmer("PPP", "QQQ", 50000,skills);
    	System.out.println("This programmer's salary is " + myProgrammer.getSalary());
    	System.out.println("This programmer's salary is " + myProgrammer2.compSkill[1]);
    	
    }
}   