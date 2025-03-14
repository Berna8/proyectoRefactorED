package store;

public class CustomerService extends Employee {

    public CustomerService(String name, int id, String department, double salary, Store store) {
        super(name, id, salary, store);
    }

    public void handleRequest(String requestType, String details) {
        if (requestType.equals("return")) {
            System.out.println("Procesando devolución: " + details);
        } else if (requestType.equals("complaint")) {
            System.out.println("Procesando queja: " + details);
        } else if (requestType.equals("feedback")) {
            System.out.println("Procesando feedback: " + details);
        } else {
            System.out.println("Solicitud no reconocida.");
        }
    }

    @Override
    public void conductMeeting() {}

    @Override
    public void submitReport() {}

    @Override
    public void approveBudget() {}
}
