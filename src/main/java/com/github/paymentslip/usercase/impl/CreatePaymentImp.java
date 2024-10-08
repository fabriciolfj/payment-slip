package com.github.paymentslip.usercase.impl;

import com.github.paymentslip.entities.Payment;
import com.github.paymentslip.usercase.CreatePayment;
import com.github.paymentslip.usercase.CreatePaymentProvider;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@RequiredArgsConstructor
public class CreatePaymentImp implements CreatePayment {

    private final CreatePaymentProvider provider;

    private static final Logger log = LoggerFactory.getLogger(CreatePayment.class);


    @Override
    public Uni<Void> execute(final Payment payment) {
        log.info("receive payment {}", payment.getUuid());

        return Panache.withTransaction(() -> provider.save(payment)
                .invoke(value -> log.info("save success payment {}", value.getUuid()))
                .replaceWithVoid());
    }
}
