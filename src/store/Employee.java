package store;

public abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;
    protected Store store;

    public Employee(String name, int id, double salary, Store store) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public abstract void conductMeeting();
    public abstract void submitReport();
    public abstract void approveBudget();
}
