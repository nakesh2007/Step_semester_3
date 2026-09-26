import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Employee {

    protected int employeeId;
    protected String name;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

   
    public abstract boolean isLeaveAllowed(int days);
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public boolean isLeaveAllowed(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public boolean isLeaveAllowed(int days) {
        return days <= 10;
    }
}

class Contractor extends Employee {

    public Contractor(int employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public boolean isLeaveAllowed(int days) {
        return days <= 5;
    }
}

enum LeaveStatus {
    PENDING,
    APPROVED,
    REJECTED
}

class LeaveRequest {

    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveStatus status;

    public LeaveRequest(
            Employee employee,
            LocalDate startDate,
            LocalDate endDate) {

        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = LeaveStatus.PENDING;
    }

    public int getDays() {
        return (int) ChronoUnit.DAYS.between(
                startDate,
                endDate
        ) + 1;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void approve() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot approve. Current status: " + status
            );
            return;
        }

        if (!employee.isLeaveAllowed(getDays())) {
            System.out.println(
                "Leave not allowed for " + employee.getName()
            );
            return;
        }

        status = LeaveStatus.APPROVED;

        System.out.println(
            employee.getName() +
            "'s leave request (" +
            startDate + " to " +
            endDate +
            ") approved."
        );
    }

    public void reject() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot reject. Current status: " + status
            );
            return;
        }

        status = LeaveStatus.REJECTED;

        System.out.println(
            employee.getName() +
            "'s leave request (" +
            startDate + " to " +
            endDate +
            ") rejected."
        );
    }

    public void changeStatus(LeaveStatus newStatus) {

        if (status != LeaveStatus.PENDING) {

            System.out.println(
                "Cannot change leave request status from " +
                status +
                " to " +
                newStatus
            );

            return;
        }

        status = newStatus;
    }

    public void display() {

        System.out.println(
            "Leave request submitted for " +
            employee.getName() +
            " (" +
            startDate +
            " to " +
            endDate +
            "). Status: " +
            status
        );
    }
}

class LeaveService {

    public LeaveRequest submitLeave(
            Employee employee,
            LocalDate start,
            LocalDate end) {

        LeaveRequest request =
            new LeaveRequest(employee, start, end);

        request.display();

        return request;
    }
}

public class EmployeeLeaveSystem {

    public static void main(String[] args) {

        Employee john =
            new FullTimeEmployee(1, "John");

        Employee jane =
            new PartTimeEmployee(2, "Jane");

        LeaveService service = new LeaveService();

        
        LeaveRequest johnLeave =
            service.submitLeave(
                john,
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 5)
            );


        johnLeave.approve();

        System.out.println(
            "Status: " + johnLeave.getStatus()
        );

        johnLeave.changeStatus(LeaveStatus.PENDING);

        System.out.println();

        LeaveRequest janeLeave =
            service.submitLeave(
                jane,
                LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 11)
            );

       
        janeLeave.reject();

        System.out.println(
            "Status: " + janeLeave.getStatus()
        );
    }
}