package com.rafaeltmbr.tipcalculator.common.utils

import java.text.NumberFormat
import kotlin.math.ceil

internal fun calculateTip(
    costOfService: Double,
    tipPercentage: Double,
    roundUp: Boolean = false,
): String {
    var tipAmount = costOfService * (tipPercentage / 100.0)

    if (roundUp) tipAmount = ceil(tipAmount)

    if (tipAmount < 0) tipAmount = 0.0

    return NumberFormat.getCurrencyInstance().format(tipAmount)
}