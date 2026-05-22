package com.subtle.employee.server.repository;

import com.subtle.employee.server.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByDepartment(String department);

    Employee findByEmail(String email);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByDepartmentAndName(String department, String name);
}