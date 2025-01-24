package com.example.hr_management.repository;

import com.example.hr_management.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    // 특정 직원(Employee)의 급여 기록 조회
    List<Salary> findByEmployeeId(Long employeeId);
}
