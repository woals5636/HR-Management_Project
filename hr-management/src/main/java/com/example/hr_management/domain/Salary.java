package com.example.hr_management.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private BigDecimal amount; // 급여 금액

    @Column(nullable = false, length = 10)
    private String month; // 지급 월 (e.g., 2025-01)

    // Getter, Setter, Constructor 생략 가능
}