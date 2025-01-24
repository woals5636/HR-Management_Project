package com.example.hr_management.controller;

import com.example.hr_management.domain.Attendance;
import com.example.hr_management.domain.Employee;
import com.example.hr_management.service.AttendanceService;
import com.example.hr_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final EmployeeService employeeService;

    public AttendanceController(AttendanceService attendanceService, EmployeeService employeeService) {
        this.attendanceService = attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<Attendance>> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(attendanceService.getAttendanceByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance, @RequestParam Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId); // 직원 조회
        attendance.setEmployee(employee); // 출결과 직원 연관 설정
        Attendance savedAttendance = attendanceService.addAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
