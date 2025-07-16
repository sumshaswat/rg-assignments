package Q6;

public class Main {
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Alice", "HR"));
        crud.addEmployee(new Employee(2, "Bob", "IT"));

        // Read
        System.out.println(crud.getEmployeeById(1));

        // Update
        crud.updateEmployee(2, "Bobby", "Finance");

        // Delete
        crud.deleteEmployee(1);
    }
}

