package Q7;

import java.sql.*;

public class EmployeeJDBC {
    private Connection con;

    public EmployeeJDBC() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "your_password");
    }

    // CREATE
    public void addEmployee(Employee e) throws SQLException {
        String query = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setString(3, e.getDepartment());
        ps.executeUpdate();
        System.out.println("Employee added successfully.");
    }

    // READ
    public Employee getEmployee(int id) throws SQLException {
        String query = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
        }
        return null;
    }

    // UPDATE
    public void updateEmployee(Employee e) throws SQLException {
        String query = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, e.getName());
        ps.setString(2, e.getDepartment());
        ps.setInt(3, e.getId());
        ps.executeUpdate();
        System.out.println("Employee updated successfully.");
    }

    // DELETE
    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Employee deleted successfully.");
    }

    // Close the connection
    public void close() throws SQLException {
        if (con != null) con.close();
    }
}

