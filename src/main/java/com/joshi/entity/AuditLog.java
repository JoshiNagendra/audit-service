package com.joshi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;


@Entity
@Table(name="audit_logs")
@Data
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String sourceService;
    private String topic;
    private String payload;

    private Instant timestamp;
}
