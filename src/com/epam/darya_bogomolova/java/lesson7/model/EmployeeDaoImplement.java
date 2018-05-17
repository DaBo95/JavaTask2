package com.epam.darya_bogomolova.java.lesson7.model;

import com.epam.darya_bogomolova.java.lesson7.interfaces.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplement implements EmployeeDao {
    MyConnection conn = null;
    Statement stmt = null;
    PreparedStatement stat = null;

    public EmployeeDaoImplement(MyConnection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Employee employee) {
        try {
            Connection connection = MyConnection.getConnection();
            PreparedStatement stat = connection.prepareStatement("INSERT INTO employees (firstname, lastname) " +
                    "VALUES(?, ?, ?, ?)");

            stat.setString(1, employee.getName());
            stat.setString(2, employee.getSurname());
            stat.setString(3, employee.getDepartment());
            stat.setInt(4, employee.getSalary());
            stat.executeUpdate();
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> selectAll() {
        Connection connection = MyConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Employee";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");

                Employee employee = new Employee();
                employee.setName(name);
                employee.setSurname(surname);
                employee.setDepartment(department);
                employee.setSalary(salary);

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
