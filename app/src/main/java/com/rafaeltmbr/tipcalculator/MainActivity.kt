package com.rafaeltmbr.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaeltmbr.tipcalculator.ui.screens.TipCalculatorScreen
import com.rafaeltmbr.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                TipCalculatorScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TipCalculatorScreenPreview() {
    TipCalculatorTheme {
        TipCalculatorScreen()
    }
}