package com.example.hr_management.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // 직원

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 10)
    private String status; // 출근, 조퇴 등

    // Getter, Setter, Constructor 생략 가능
}