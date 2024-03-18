package com.mohamedfathidev.gurdapi.DAO;

import com.mohamedfathidev.gurdapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee findEmployee(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
