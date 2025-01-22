package com.example.hr_management.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false) // 작성자
    private Employee employee;

    // Getter, Setter, Constructor 생략 가능
}