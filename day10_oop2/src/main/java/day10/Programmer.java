package day10;

public class Programmer extends Employee {
	public String[] compSkill;
	
	public Programmer(String firstnameInput, String lastnameInput, int salaryInput) {
		super(firstnameInput, lastnameInput, salaryInput);
		this.compSkill = new String[] {"Java"};
	}
	public Programmer(String firstnameInput, String lastnameInput, int salaryInput, String[] skillInput) {
		super(firstnameInput, lastnameInput, salaryInput);
		this.compSkill = skillInput;
	}	
	

	public void fixPC(String serialNumber) {
		System.out.println("I'm trying to fix PC serialNumber:" + serialNumber);
	}

	// สร้าง Method createWebsite()
	public void createWebsite(String template, String titleName) {
		System.out.println("I'm creating " + titleName + " using " + template + " template");
	}

	// สร้าง Method installWindows()
	public void installWindows(String version, String productKey) {
		System.out.println("I'm installing window " + version + " using product key : " + productKey);
	}

}
