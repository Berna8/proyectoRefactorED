package store;

public abstract class Employee {
    protected String name;
    protected int id;
    protected String department;
    protected double salary;

    public Employee(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public abstract void conductMeeting();
    public abstract void submitReport();
    public abstract void approveBudget();
}
