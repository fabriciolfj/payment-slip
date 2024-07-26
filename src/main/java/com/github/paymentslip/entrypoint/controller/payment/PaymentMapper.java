package com.github.paymentslip.entrypoint.controller.payment;

import com.github.paymentslip.entities.IdentifierPayment;
import com.github.paymentslip.entities.Issuer;
import com.github.paymentslip.entities.Payment;
import com.github.paymentslip.entities.Recipient;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentMapper {

    private PaymentMapper() {}

    public static Payment toEntity(final PaymentRequest request) {
        final IdentifierPayment identifier = IdentifierPayment
                .builder()
                .pix(request.getPix())
                .barcode(request.getBarcode())
                .digitalLine(request.getDigitalLine())
                .build();

        final Recipient recipient = new Recipient(request.getRecipient());
        final Issuer issuer = new Issuer(request.getIssuer());

        return Payment.builder()
                .amount(request.getAmount())
                .uuid(UUID.randomUUID().toString())
                .dueDate(request.getDueDate())
                .register(LocalDateTime.now())
                .recipient(recipient)
                .issuer(issuer)
                .identifierPayment(identifier)
                .build();
    }

    public static PaymentResponse toResponse(final Payment payment) {
        return new PaymentResponse(payment.getUuid());
    }
}
