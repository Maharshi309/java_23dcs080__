//18
class Member{
    String name;
    int age;
    String phonenumber;
    String address;
    double salary;

    void printsalary(){
        System.err.println("salary" + salary);
    }

}

class Employee extends Member{

    String specialization;

}

class Manager extends Member{

    String department;

}
public class Comp {
    public static void main(String[] args) {
        Employee employee = new Employee();

        // employee

        employee.name = "Maharshi Patel";
        employee.age = 30;
        employee.phonenumber = "123-456-7890";
        employee.address = "Nadiad";
        employee.salary = 50000;
        employee.specialization = "Software Development";
        
        // Print employee's details
        System.out.println("Employee Details:");
        System.out.println("Name: " + employee.name);
        System.out.println("Age: " + employee.age);
        System.out.println("Phone Number: " + employee.phonenumber);
        System.out.println("Address: " + employee.address);
        System.out.println("Specialization: " + employee.specialization);
        employee.printsalary();
        
        
        Manager manager = new Manager();
        
        manager.name = "Ramesh Patel";
        manager.age = 40;
        manager.phonenumber = "098-765-4321";
        manager.address = "Modasa";
        manager.salary = 70000;
        manager.department = "HR";
        
        //  manager
        System.out.println("\nManager Details:");
        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Phone Number: " + manager.phonenumber);
        System.out.println("Address: " + manager.address);
        System.out.println("Department: " + manager.department);
        manager.printsalary();

        System.out.println("23DCS080 Maharshi Patel ");
    }

    }
    

