package com.paymentservice.service;

import com.paymentservice.dto.PaymentRequestDTO;
import com.paymentservice.dto.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO processPayment(PaymentRequestDTO request);

    PaymentResponseDTO getPaymentById(Long paymentId);
}
