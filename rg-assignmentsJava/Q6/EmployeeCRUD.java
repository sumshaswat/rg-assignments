package Q6;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Employee added successfully.");
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String newName, String newDepartment) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setDepartment(newDepartment);
            System.out.println("Employee updated successfully.");
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Employee deleted successfully.");
            return true;
        }
        return false;
    }
}
