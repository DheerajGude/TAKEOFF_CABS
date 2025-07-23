package com.paymentservice.dto;

import com.paymentservice.enums.PaymentMethod;
import com.paymentservice.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private Long paymentId;
    private Long userId;
    private Long bookingId;
    private BigDecimal amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime timestamp;
}
