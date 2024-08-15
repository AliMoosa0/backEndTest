package com.backendtest.backendtest.repository;

import com.backendtest.backendtest.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
