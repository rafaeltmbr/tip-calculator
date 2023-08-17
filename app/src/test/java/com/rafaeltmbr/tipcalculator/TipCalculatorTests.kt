package com.rafaeltmbr.tipcalculator

import com.rafaeltmbr.tipcalculator.common.utils.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

private data class CalculateTipData(
    val service: Double,
    val percent: Double,
    val tip: String,
    val tipRoundUp: String,
)

/**
 * Format the number using the Local Currency format.
 *
 * *Example:*
 *
 * ```kt
 * f(25.689) // "25.68" # for US dollar
 * ```
 *
 * @param n the given number to be formatted
 */
fun f(n: Double): String = NumberFormat.getCurrencyInstance().format(n)

private val calculateTipAssertionData = arrayOf(
    CalculateTipData(service = 0.0, percent = 0.0, tip = f(0.0), tipRoundUp = f(0.0)),
    CalculateTipData(service = -100.0, percent = 1.0, tip = f(0.0), tipRoundUp = f(0.0)),
    CalculateTipData(service = 1.0, percent = -100.0, tip = f(0.0), tipRoundUp = f(0.0)),
    CalculateTipData(service = 100.0, percent = 1.0, tip = f(1.0), tipRoundUp = f(1.0)),
    CalculateTipData(service = 200.0, percent = 5.0, tip = f(10.0), tipRoundUp = f(10.0)),
    CalculateTipData(service = 60.0, percent = 200.0, tip = f(120.0), tipRoundUp = f(120.0)),
    CalculateTipData(service = 29.80, percent = 10.0, tip = f(2.98), tipRoundUp = f(3.0)),
    CalculateTipData(service = 145.90, percent = 10.0, tip = f(14.59), tipRoundUp = f(15.0)),
    CalculateTipData(service = 177.12, percent = 29.61, tip = f(52.45), tipRoundUp = f(53.0)),
    CalculateTipData(service = 1000.0, percent = 1000.0, tip = f(10000.0), tipRoundUp = f(10000.0)),
)

class TipCalculatorTests {
    @Test
    fun calculateTipNoRoundUp() {
        for (data in calculateTipAssertionData) {
            val tip = calculateTip(
                costOfService = data.service,
                tipPercentage = data.percent
            )
            assertEquals(data.tip, tip)
        }
    }

    @Test
    fun calculateTipRoundUp() {
        for (data in calculateTipAssertionData) {
            val tip = calculateTip(
                costOfService = data.service,
                tipPercentage = data.percent,
                roundUp = true
            )
            assertEquals(data.tipRoundUp, tip)
        }
    }
}