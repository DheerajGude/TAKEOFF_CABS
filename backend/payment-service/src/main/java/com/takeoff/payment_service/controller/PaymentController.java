package com.paymentservice.controller;

import com.paymentservice.dto.PaymentRequestDTO;
import com.paymentservice.dto.PaymentResponseDTO;
import com.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // POST /api/payments — Process new payment
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentRequestDTO request) {
        PaymentResponseDTO response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    // GET /api/payments/{id} — Fetch payment details
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable Long id) {
        PaymentResponseDTO response = paymentService.getPaymentById(id);
        return ResponseEntity.ok(response);
    }
}
