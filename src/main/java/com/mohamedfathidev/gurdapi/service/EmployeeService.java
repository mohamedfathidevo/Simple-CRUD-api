package com.mohamedfathidev.gurdapi.service;

import com.mohamedfathidev.gurdapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
