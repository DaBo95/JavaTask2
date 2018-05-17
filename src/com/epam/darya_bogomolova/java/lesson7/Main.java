package com.epam.darya_bogomolova.java.lesson7;

import com.epam.darya_bogomolova.java.lesson7.interfaces.EmployeeDao;
import com.epam.darya_bogomolova.java.lesson7.model.Employee;
import com.epam.darya_bogomolova.java.lesson7.model.EmployeeDaoImplement;
import com.epam.darya_bogomolova.java.lesson7.model.MyConnection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        myConnection.process("jdbc:mysql://localhost:3306/Employees", "Dasha", "Dar123");

        EmployeeDao employeeDao = new EmployeeDaoImplement(myConnection);


        List<Employee> employeeList = employeeDao.selectAll();

        for(Employee e: employeeList) {
            for (int i = 0; i < 10; i++) {
                employeeDao.insert(e);
            }
        }


        myConnection.close();
    }
}
