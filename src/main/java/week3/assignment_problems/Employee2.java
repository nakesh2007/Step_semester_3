class Employee2 {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee2(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee2 e1 = new Employee2("Anita", 40000);
        Employee2 e2 = new Employee2("Ravi", 45000);
        Employee2 e3 = new Employee2("Meena", 42000);

        Employee2.printCompanyInfo();
    }
}