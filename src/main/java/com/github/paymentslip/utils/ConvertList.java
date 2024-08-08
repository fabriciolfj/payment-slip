package com.github.paymentslip.utils;

import java.util.Arrays;
import java.util.List;

public class ConvertList {

    private ConvertList() { }


    public static <T> List<T> createList(T... elements) {
        return Arrays.asList(elements);
    }
}
