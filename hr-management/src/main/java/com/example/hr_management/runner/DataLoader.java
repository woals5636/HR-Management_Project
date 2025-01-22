package com.example.hr_management.runner;

import com.example.hr_management.domain.Employee;
import com.example.hr_management.domain.Role;
import com.example.hr_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setEmail("john.doe@example.com");
        employee1.setPhone("010-1234-5678");
        employee1.setDepartment("HR");
        employee1.setPosition("Manager");
        employee1.setRole(Role.USER);
        employeeRepository.save(employee1);
    }
}