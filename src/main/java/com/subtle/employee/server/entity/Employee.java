package com.subtle.employee.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message="Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10digits long")
    private String phone;

    @NotBlank(message = "Department is required")
    private String department;

}
