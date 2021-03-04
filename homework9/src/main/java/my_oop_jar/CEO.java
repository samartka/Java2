package my_oop_jar;

public class CEO extends Employee {
    public CEO(String firstnameInput, String lastnameInput, int salaryInput) {
        super(firstnameInput, lastnameInput, salaryInput);
    }
    public int getSalary(){
        return super.getSalary()*2;
    };
    public void work (Employee luckyEmployee) {
        //this.fire(luckyEmployee);
        //this.hire(luckyEmployee);
        //this.seminar();
        this.golf();
    }
    public void assignNewSalary(Employee luckyEmployee, int newSalary) {
        // เขียนให้ตรวจว่าเงินเดือนน้อยกว่าเดิมหรือไม่ 
        // หากเงินเดือนน้อยกว่าเดิมให้ขึ้นข้อความว่า <ชื่อพนักงาน>'s salary is less than before!! และไม่ต้อง set เงินเดือนใหม่ให้พนักงานคนนั้น
        // หากเงินเดือนมากกว่าเดิมให้ set เงินเดือนใหม่ให้สำเร็จ และขึ้นข้อความว่า <ชื่อพนักงาน>'s salary has been set to <newSalary>
    }
    private void golf () { // simulate private method
        //this.dressCode = "golf_dress";
        //System.out.println("He goes to golf club to find a new connection. Dress with :" + this.dressCode);
    };
}
