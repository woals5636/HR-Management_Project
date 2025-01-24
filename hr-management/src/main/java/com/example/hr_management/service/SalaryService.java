package com.example.hr_management.service;

import com.example.hr_management.domain.Salary;
import com.example.hr_management.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<Salary> getSalaryByEmployeeId(Long employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }

    public Salary addSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
