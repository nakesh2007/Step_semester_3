class Employee {
    String id;
    double salary;

    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }

    void display() {
        System.out.println(id + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        double[] salaries = {40000, 55000, 62000, 48000};
        Employee[] employees = new Employee[salaries.length];

        for (int i = 0; i < salaries.length; i++) {
            employees[i] = new Employee("E-" + (101 + i), salaries[i]);
        }

        for (Employee employee : employees) {
            employee.raiseSalary(5000);
            employee.display();
        }
    }
}