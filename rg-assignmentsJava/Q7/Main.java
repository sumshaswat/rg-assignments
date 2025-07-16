package Q7;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeJDBC db = new EmployeeJDBC();

            // CREATE
            Employee e1 = new Employee(1, "Alice", "HR");
            db.addEmployee(e1);

            // READ
            Employee fetched = db.getEmployee(1);
            System.out.println("Fetched: " + fetched);

            // UPDATE
            e1.setName("Alice Smith");
            e1.setDepartment("Finance");
            db.updateEmployee(e1);

            // DELETE
            db.deleteEmployee(1);

            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
