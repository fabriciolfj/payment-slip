package com.github.paymentslip.entrypoint.controller.payment;

import com.github.paymentslip.entities.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static Payment toEntity(final PaymentRequest request) {
        final Map<TypePayment, String> values = new HashMap<>();
        values.put(TypePayment.PIX, request.getPix());
        values.put(TypePayment.BARCODE, request.getBarcode());
        values.put(TypePayment.DIGITAL_LINE, request.getDigitalLine());

        var result = values.entrySet()
                .stream()
                .filter(e -> e.getValue() != null)
                .collect(Collectors.toSet());

        if (result.size() != 1) {
            throw new IllegalArgumentException("more or none methods payment informed");
        }

        final IdentifierPayment identifier = IdentifierPayment
                .builder()
                .type(result.stream().findFirst().get().getKey())
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
