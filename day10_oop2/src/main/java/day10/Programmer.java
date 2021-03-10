package day10;
import day10.my_interface.IWebsiteCreator;
import day10.my_interface.IWindowsInstaller;


public class Programmer extends Employee implements IWebsiteCreator, IWindowsInstaller {
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

	public void formatWindows(String drive) {
		System.out.println("I'm formatting window on drive " + drive);
		
	}
	public int getLastInstalledWindowsVersion() {
		return 10;
	}
	
	
}
