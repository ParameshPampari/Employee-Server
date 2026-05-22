package com.subtle.employee.server.service;

import com.subtle.employee.server.entity.Employee;
import com.subtle.employee.server.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // CREATE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ BY ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);

        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setPhone(updatedEmployee.getPhone());
        existing.setDepartment(updatedEmployee.getDepartment());

        return employeeRepository.save(existing);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // FIND BY
    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public Employee getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}