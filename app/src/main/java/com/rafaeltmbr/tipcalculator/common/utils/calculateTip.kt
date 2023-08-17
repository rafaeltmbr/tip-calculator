package com.rafaeltmbr.tipcalculator.common.utils

import java.text.NumberFormat
import kotlin.math.ceil

fun calculateTip(
    costOfService: Double,
    tipPercentage: Double,
    roundUp: Boolean = false,
): String {
    var tipAmount = costOfService * (tipPercentage / 100.0)

    if (roundUp) {
        tipAmount = ceil(tipAmount)
    }

    return NumberFormat.getCurrencyInstance().format(tipAmount)
}