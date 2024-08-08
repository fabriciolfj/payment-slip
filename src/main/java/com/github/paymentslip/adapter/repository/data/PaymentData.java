package com.github.paymentslip.adapter.repository.data;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class PaymentData extends PanacheEntity {

    private String uuid;
    private LocalDateTime register;
    private LocalDate dueDate;
    private BigDecimal amount;
    @Column(name = "paid_out")
    private boolean paidOut;
    @Column(name = "identifier_payment")
    private String identifierPayment;
    @Column(name = "type_payment")
    private String typePayment;
    private String recipent;
    private String issuer;
}
