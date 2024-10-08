package com.github.paymentslip.entrypoint.controller.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest {

    @JsonProperty("bar_code")
    private String barcode;
    @JsonProperty("digital_line")
    private String digitalLine;
    private String pix;
    @NotNull(message = "amount is required")
    private BigDecimal amount;
    @NotBlank(message = "issuer is required")
    private String issuer;
    @NotBlank(message = "recipient is required")
    private String recipient;
    @NotNull(message = "dueDate is required")
    @JsonProperty("due_date")
    private LocalDate dueDate;
}
