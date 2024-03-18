package com.mohamedfathidev.gurdapi.service;

import com.mohamedfathidev.gurdapi.DAO.EmployeeDAO;
import com.mohamedfathidev.gurdapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.findEmployee(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
