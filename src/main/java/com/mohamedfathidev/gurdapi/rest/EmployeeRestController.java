package com.mohamedfathidev.gurdapi.rest;

import com.mohamedfathidev.gurdapi.entity.Employee;
import com.mohamedfathidev.gurdapi.service.EmployeeService;
import com.mohamedfathidev.gurdapi.util.EmployeeDeletedResponse;
import com.mohamedfathidev.gurdapi.util.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null){
            throw new EmployeeNotFoundException("No Such Employee Found With This ID");
        }
        return employee;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<EmployeeDeletedResponse> deleteEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null){
            throw new EmployeeNotFoundException("No Such Employee Found With This ID");
        }
        employeeService.deleteEmployee(employeeId);
        EmployeeDeletedResponse response = new EmployeeDeletedResponse(
                employeeId,
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
