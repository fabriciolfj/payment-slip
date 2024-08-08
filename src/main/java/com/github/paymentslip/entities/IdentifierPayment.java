package com.github.paymentslip.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class IdentifierPayment {

    private TypePayment type;
    private String barcode;
    private String digitalLine;
    private String pix;
}
