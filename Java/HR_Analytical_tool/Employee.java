import java.time.LocalDate;
import java.time.Period;

public class Employee {

    private String Ename;
    private String Department;
    private double Salary;
    private LocalDate date_of_joining;

    public Employee(String Ename, String Department, double Salary, LocalDate date_of_joiniing){

        this. Ename = Ename;
        this.Department = Department;
        this.Salary = Salary;
        this.date_of_joining  = date_of_joiniing;
    }

    public String getName(){ 
        return Ename;
    }

    public String getDepartment(){
        return Department;
    }

    public double getSalary(){
        return Salary;
    }

    public LocalDate getLocalDate(){
        return date_of_joining;
    }


    public int getExperienceInYears(){
        return Period.between(date_of_joining, LocalDate.now()).getYears();
    }
 @Override
    public String toString() {
        return String.format("%s (%s) - ₹%.2f, Joined: %s, Experience: %d years",
                Ename, Department, Salary, date_of_joining, getExperienceInYears());
    }



}
