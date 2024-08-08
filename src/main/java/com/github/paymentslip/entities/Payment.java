package com.github.paymentslip.entities;

import com.github.paymentslip.exceptions.ManyIdentifierPaymentException;
import com.github.paymentslip.utils.ConvertList;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.paymentslip.utils.ConvertList.createList;

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

    public String getIdentifierPayment() {
        var results =  createList(identifierPayment.getPix(), identifierPayment.getDigitalLine(), identifierPayment.getBarcode())
                .stream().filter(Objects::nonNull)
                .toList();

        if (results.size() != 1) {
            throw new ManyIdentifierPaymentException();
        }

        return results.getFirst();
    }

    public String getIdentifierRecipient() {
        return this.recipient.getDocument();
    }

    public String getTypePayment() {
        return this.identifierPayment.getType().name();
    }

    public String getIdentifierIssuer() {
        return this.issuer.getDocument();
    }

}
