package com.notifyservice.service.impl;

import com.notifyservice.dto.NotificationRequest;
import com.notifyservice.dto.NotificationResponse;
import com.notifyservice.entity.Notification;
import com.notifyservice.repository.NotificationRepository;
import com.notifyservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {
        // Simulate sending notification
        String status = "SENT"; // You can later add email/sms logic here

        // Save to DB
        Notification notification = Notification.builder()
                .recipient(request.getRecipient())
                .message(request.getMessage())
                .type(request.getType())
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);

        return NotificationResponse.builder()
                .status(status)
                .message("Notification sent successfully to " + request.getRecipient())
                .timestamp(notification.getTimestamp().toString())
                .build();
    }
}
