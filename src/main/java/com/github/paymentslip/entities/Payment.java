package com.github.paymentslip.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class Payment {

    private String uuid;
    private LocalDateTime register;
    private LocalDate dueDate;
    private BigDecimal amount;
    private boolean paidOut;
    private IdentifierPayment identifierPayment;
    private Recipient recipient;
    private Issuer issuer;
}
