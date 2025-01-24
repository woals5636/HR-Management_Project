package com.example.hr_management.repository;

import com.example.hr_management.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // 특정 직원(Employee)의 출결 기록 조회
    List<Attendance> findByEmployeeId(Long employeeId);
}
