package com.paymentservice.service.impl;

import com.paymentservice.dto.PaymentRequestDTO;
import com.paymentservice.dto.PaymentResponseDTO;
import com.paymentservice.entity.Payment;
import com.paymentservice.enums.PaymentStatus;
import com.paymentservice.repository.PaymentRepository;
import com.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {
        // Simulate payment logic
        Payment payment = new Payment();
        payment.setUserId(request.getUserId());
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());
        payment.setStatus(PaymentStatus.SUCCESS); // Simulated
        payment.setTimestamp(LocalDateTime.now());

        Payment saved = paymentRepository.save(payment);

        return new PaymentResponseDTO(
                saved.getId(),
                saved.getUserId(),
                saved.getBookingId(),
                saved.getAmount(),
                saved.getMethod(),
                saved.getStatus(),
                saved.getTimestamp()
        );
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return new PaymentResponseDTO(
                payment.getId(),
                payment.getUserId(),
                payment.getBookingId(),
                payment.getAmount(),
                payment.getMethod(),
                payment.getStatus(),
                payment.getTimestamp()
        );
    }
}
