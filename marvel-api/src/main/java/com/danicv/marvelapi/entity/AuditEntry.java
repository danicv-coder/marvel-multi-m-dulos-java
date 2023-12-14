package com.danicv.marvelapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Author: Daniel Calderon
@Entity
public class AuditEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "execution_time")
    private LocalDateTime executionTime;
    @Column(name = "method_name")
    private String methodName;

    public AuditEntry() {}

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
