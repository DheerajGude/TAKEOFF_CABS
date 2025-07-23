package com.notifyservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient; // email or phone

    @Column(length = 1000)
    private String message;

    private String type; // "EMAIL" or "SMS"

    private String status; // "SENT", "FAILED", etc.

    private LocalDateTime timestamp;
}
