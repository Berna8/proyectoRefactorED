package store;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private final String id;
    private String name;
    private String direction;
    private List<Employee> employeeList;
    private List<Product> inventory;


    public Store(String id, String name, String direction) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.employeeList = new LinkedList<Employee>();
        this.inventory = new LinkedList<Product>();
    }

    // TODO refactor
    public List<Product> getInventory() {
        return new LinkedList<Product>(inventory);
    }

    public void setInventory(List<Product> inventory) {
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


}
