package com.subtle.employee.server.controller;

import com.subtle.employee.server.entity.Employee;
import com.subtle.employee.server.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // CREATE
    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // READ ALL
    @GetMapping
    public java.util.List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // FIND BY DEPARTMENT
    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return employeeService.getByDepartment(dept);
    }

    // FIND BY EMAIL
    @GetMapping("/email")
    public Employee getByEmail(@RequestParam String email) {
        return employeeService.getByEmail(email);
    }
}