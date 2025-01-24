package com.example.hr_management.controller;

import com.example.hr_management.domain.Employee;
import com.example.hr_management.domain.Salary;
import com.example.hr_management.service.EmployeeService;
import com.example.hr_management.service.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    private final SalaryService salaryService;
    private final EmployeeService employeeService;

    public SalaryController(SalaryService salaryService, EmployeeService employeeService) {
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<Salary>> getSalaryByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(salaryService.getSalaryByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<Salary> addSalary(@RequestBody Salary salary, @RequestParam Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId); // 직원 조회
        salary.setEmployee(employee); // 급여와 직원 연관 설정
        Salary savedSalary = salaryService.addSalary(salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
