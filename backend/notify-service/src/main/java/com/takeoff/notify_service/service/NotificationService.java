package com.notifyservice.service;

import com.notifyservice.dto.NotificationRequest;
import com.notifyservice.dto.NotificationResponse;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
}
