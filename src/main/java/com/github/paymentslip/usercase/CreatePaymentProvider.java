package com.github.paymentslip.usercase;

import com.github.paymentslip.entities.Payment;
import io.smallrye.mutiny.Uni;

public interface CreatePaymentProvider {

    Uni<Payment> save(final Payment payment);
}
