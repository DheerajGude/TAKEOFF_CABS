package com.notifyservice.controller;

import com.notifyservice.dto.NotificationRequest;
import com.notifyservice.dto.NotificationResponse;
import com.notifyservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResponse> sendNotification(
            @RequestBody NotificationRequest request) {

        NotificationResponse response = notificationService.sendNotification(request);
        return ResponseEntity.ok(response);
    }
}
