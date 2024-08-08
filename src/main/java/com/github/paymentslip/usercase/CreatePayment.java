package com.github.paymentslip.usercase;

import com.github.paymentslip.entities.Payment;
import io.smallrye.mutiny.Uni;

public interface CreatePayment {

    Uni<Void> execute(final Payment payment);
}
