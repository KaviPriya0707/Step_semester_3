class Employee {

    String empId;
    double salary;

    Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void printSalary() {
        System.out.println(
            empId + " | Final Salary: Rs " + salary
        );
    }
}

class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[4];

        employees[0] = new Employee("E-101", 40000);
        employees[1] = new Employee("E-102", 55000);
        employees[2] = new Employee("E-103", 62000);
        employees[3] = new Employee("E-104", 48000);

        double bonus = 5000;

        for (int i = 0; i < employees.length; i++) {

            employees[i].raiseSalary(bonus);
            employees[i].printSalary();
        }
    }
}
