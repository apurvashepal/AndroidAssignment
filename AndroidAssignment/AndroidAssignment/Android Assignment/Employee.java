import java.util.Scanner;

public class Employee{
        int id,
        String name,
        int age,
        String designation,
        int basicSalary,
        int HRA,
        int Incentives
};

public interface IEmployee{
    public void addEmployee(Employee);
    public void deleteEmployee(Employee);
    public int calculateSalary();
}

class Developer implements IEmployee{
    public void addEmployee(Employee developer){
        EmployeeList.Add(developer);
    }
    public void deleteEmployee(Employee developer){
        EmployeeList.Remove(developer);
    }
    public int calculateSalary(){
        
        return  basicSalary;
    }
}


class Manager implements IEmployee{
    public void addEmployee(Employee Manager){
        EmployeeList.Add(Manager);
    }
    public void deleteEmployee(Employee Manager){
        EmployeeList.Remove(Manager);
    }
    public int calculateSalary(){
        
        return  basicSalary + HRA;
    }
}

class SalesExecutive implements IEmployee{
    public void addEmployee(Employee SalesExecutive){
        EmployeeList.Add(SalesExecutive);
    }
    public void deleteEmployee(Employee SalesExecutive){
        EmployeeList.Remove(SalesExecutive);
    }
    public int calculateSalary(){
        
        return  basicSalary + HRA + Insentive;
    }
}





class Assignment2{
        public static void main(string Args[]){
            ArrayList<Employee> EmployeeList=new ArrayList<>();
        }
}