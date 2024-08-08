package com.github.paymentslip.adapter.repository;

import com.github.paymentslip.adapter.repository.data.PaymentData;
import com.github.paymentslip.adapter.repository.mapper.PaymentDataMapper;
import com.github.paymentslip.entities.Payment;
import com.github.paymentslip.usercase.CreatePaymentProvider;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import static io.smallrye.mutiny.Uni.createFrom;


@ApplicationScoped
public class PaymentSlipRepository implements PanacheRepositoryBase<PaymentData, Long>, CreatePaymentProvider {

    @Override
    public Uni<Payment> save(final Payment payment) {
        return createFrom()
                .item(payment).onItem()
                .transform(PaymentDataMapper::toData)
                .map(this::persist)
                .replaceWith(Uni.createFrom().item(payment));
    }
}
