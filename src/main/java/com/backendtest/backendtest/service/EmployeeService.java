package com.backendtest.backendtest.service;

import com.backendtest.backendtest.model.Employee;
import com.backendtest.backendtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public String addEmployee(Employee employee) {
        // Generate a new unique employee ID
        String employeeID = UUID.randomUUID().toString().split("-")[0];
        employee.setEmployeeID(employeeID);

        // Save the employee to the repository
        Employee savedEmployee = employeeRepository.save(employee);

        // Return only the employee ID
        return savedEmployee.getEmployeeID();
    }


    // Get Employee by ID
    public Employee getEmployeeByID(String employeeID) {
        return employeeRepository.findById(employeeID).orElse(null);
    }

    // Get Employees with filters
    public List<Employee> getEmployees(String name, Integer fromSalary, Integer toSalary) {
        List<Employee> employees = employeeRepository.findAll();

        if (name != null && !name.isEmpty()) {
            employees = employees.stream()
                    .filter(e -> e.getFirstName().contains(name) || e.getLastName().contains(name))
                    .collect(Collectors.toList());
        }

        if (fromSalary != null) {
            employees = employees.stream()
                    .filter(e -> Integer.parseInt(e.getSalary()) >= fromSalary)
                    .collect(Collectors.toList());
        }

        if (toSalary != null) {
            employees = employees.stream()
                    .filter(e -> Integer.parseInt(e.getSalary()) <= toSalary)
                    .collect(Collectors.toList());
        }

        return employees;
    }
}