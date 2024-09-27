package com.github.paymentslip.entrypoint.controller.payment;

import com.github.paymentslip.usercase.CreatePayment;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentSlipController {

    private final CreatePayment cratePayment;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> createPayment(@Valid final PaymentRequest paymentRequest) {
        return Uni.createFrom().item(paymentRequest)
                .invoke(value -> log.info("Payment request: {}", value))
                .map(PaymentMapper::toEntity)
                .invoke(entity -> log.info("Entity create start {}", entity.getUuid()))
                .flatMap(cratePayment::execute)
                .map(entity -> Response.noContent().build())
                .onFailure().recoverWithItem(value -> Response.status(Response.Status.BAD_REQUEST).entity(value).build());
    }

    @GET
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getPayment(@QueryParam("uuid") final String uuid) {
        return Uni.createFrom()
                .item(uuid)
                .map(value -> Response.ok(value).build())
                .onFailure().recoverWithItem(value -> Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity(value).build());
    }
}
