package com.epam.darya_bogomolova.java.lesson7.interfaces;

import com.epam.darya_bogomolova.java.lesson7.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void insert(Employee employee);
    public List<Employee> selectAll();

}
