package com.rafaeltmbr.tipcalculator

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import com.rafaeltmbr.tipcalculator.ui.screens.TipCalculatorScreen
import com.rafaeltmbr.tipcalculator.ui.screens.roundTipSwitchTestTag
import com.rafaeltmbr.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun calculateTipNoRoundUp() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorScreen()
            }
        }

        composeTestRule.onNodeWithText(context.getString(R.string.service_value_label))
            .assertExists("Service cost input not found")
            .performTextInput("50")

        composeTestRule.onNodeWithText(context.getString(R.string.tip_value_label))
            .assertExists("Tip percentage input not found")
            .performTextClearance()

        composeTestRule.onNodeWithText(context.getString(R.string.tip_value_label))
            .assertExists("Tip percentage input not found")
            .performTextInput("25")

        val tip = NumberFormat.getCurrencyInstance().format(12.5)

        composeTestRule.onNodeWithText(context.getString(R.string.tip_result_message, tip))
            .assertExists("Tip result not found")
    }

    @Test
    fun calculateTipRoundUp() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorScreen()
            }
        }

        composeTestRule.onNodeWithText(context.getString(R.string.service_value_label))
            .assertExists("Service cost input not found")
            .performTextInput("50")

        composeTestRule.onNodeWithText(context.getString(R.string.tip_value_label))
            .assertExists("Tip percentage input not found")
            .performTextClearance()

        composeTestRule.onNodeWithText(context.getString(R.string.tip_value_label))
            .assertExists("Tip percentage input not found")
            .performTextInput("25")

        composeTestRule.onNodeWithTag(roundTipSwitchTestTag)
            .assertExists()
            .performClick()

        val tip = NumberFormat.getCurrencyInstance().format(13.0)

        composeTestRule.onNodeWithText(context.getString(R.string.tip_result_message, tip))
            .assertExists("Tip result not found")
    }
}