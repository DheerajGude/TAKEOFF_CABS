package com.paymentservice.dto;

import com.paymentservice.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {
    private Long userId;
    private Long bookingId;
    private BigDecimal amount;
    private PaymentMethod method;
}
