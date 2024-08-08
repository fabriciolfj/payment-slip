package com.github.paymentslip.adapter.repository.mapper;

import com.github.paymentslip.adapter.repository.data.PaymentData;
import com.github.paymentslip.entities.Payment;

public class PaymentDataMapper {

    private PaymentDataMapper() {}

    public static PaymentData toData(final Payment payment) {
        return PaymentData.builder()
                .uuid(payment.getUuid())
                .paidOut(payment.isPaidOut())
                .amount(payment.getAmount())
                .dueDate(payment.getDueDate())
                .typePayment(payment.getTypePayment())
                .identifierPayment(payment.getIdentifierPayment())
                .issuer(payment.getIdentifierIssuer())
                .register(payment.getRegister())
                .recipent(payment.getIdentifierRecipient())
                .build();
    }
}
