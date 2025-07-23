package com.notifyservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private String recipient;     // email or phone number
    private String message;       // message content
    private String type;          // "EMAIL" or "SMS"
}
