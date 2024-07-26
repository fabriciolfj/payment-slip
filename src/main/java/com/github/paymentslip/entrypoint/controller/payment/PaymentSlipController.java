package com.github.paymentslip.entrypoint.controller.payment;

import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/api/v1/payment")
public class PaymentSlipController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> createPayment(@Valid final PaymentRequest paymentRequest) {
        return Uni.createFrom().item(paymentRequest)
                .invoke(value -> log.info("Payment request: {}", value))
                .map(PaymentMapper::toEntity)
                .invoke(entity -> log.info("Entity create start {}", entity.getUuid()))
                .map(entity -> Response.ok(PaymentMapper.toResponse(entity)).build())
                .onFailure().recoverWithItem(value -> Response.status(Response.Status.BAD_REQUEST).entity(value).build());
    }
}
