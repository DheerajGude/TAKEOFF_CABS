package com.notifyservice.exception;

import com.notifyservice.dto.NotificationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<NotificationResponse> handleNotificationException(NotificationException ex) {
        NotificationResponse response = NotificationResponse.builder()
                .status("FAILED")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now().toString())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<NotificationResponse> handleGeneralException(Exception ex) {
        NotificationResponse response = NotificationResponse.builder()
                .status("ERROR")
                .message("Internal Server Error: " + ex.getMessage())
                .timestamp(LocalDateTime.now().toString())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
