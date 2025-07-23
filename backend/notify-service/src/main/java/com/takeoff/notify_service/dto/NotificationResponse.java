package com.notifyservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {

    private String status;        // "SENT", "FAILED", etc.
    private String message;       // Additional info or error message
    private String timestamp;     // Sent time as string
}
