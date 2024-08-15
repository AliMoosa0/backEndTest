package com.backendtest.backendtest.controller;

import com.backendtest.backendtest.model.Employee;
import com.backendtest.backendtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        String employeeID = employeeService.addEmployee(employee);
        return ResponseEntity.ok(employeeID);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeByID(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) Integer fromSalary,
                                                       @RequestParam(required = false) Integer toSalary) {
        List<Employee> employees = employeeService.getEmployees(name, fromSalary, toSalary);
        return ResponseEntity.ok(employees);
    }
}
