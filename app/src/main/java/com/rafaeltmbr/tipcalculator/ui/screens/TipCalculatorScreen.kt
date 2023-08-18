package com.rafaeltmbr.tipcalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafaeltmbr.tipcalculator.R
import com.rafaeltmbr.tipcalculator.common.utils.calculateTip
import com.rafaeltmbr.tipcalculator.ui.components.BooleanQuestionRow
import com.rafaeltmbr.tipcalculator.ui.components.NumericField

internal val roundTipSwitchTestTag = "roundTipSwitchTestTag"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TipCalculatorScreen(
    modifier: Modifier = Modifier,
) {
    val defaultTipPercentage = stringResource(id = R.string.default_tip_percentage)
    var tipPercentage by remember { mutableStateOf(defaultTipPercentage) }
    var costOfService by remember { mutableStateOf("") }
    var roundTipUp by remember { mutableStateOf(false) }

    val tipAmount = calculateTip(
        costOfService = costOfService.toDoubleOrNull() ?: 0.0,
        tipPercentage = tipPercentage.toDoubleOrNull() ?: 0.0,
        roundUp = roundTipUp,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .then(modifier)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .then(modifier),
        ) {
            Text(
                text = stringResource(id = R.string.screen_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
            NumericField(
                label = R.string.service_value_label,
                value = costOfService,
                imeAction = ImeAction.Next,
                onValueChange = { costOfService = it },
//                leadingIcon = { Icon(Icons.Outlined.List, contentDescription = null) }
            )

            Spacer(modifier = Modifier.height(24.dp))
            NumericField(
                label = R.string.tip_value_label,
                value = tipPercentage,
                imeAction = ImeAction.Done,
                onValueChange = { tipPercentage = it },
//                leadingIcon = { Icon(Icons.Outlined.Star, contentDescription = null) }
            )

            Spacer(modifier = Modifier.height(16.dp))
            BooleanQuestionRow(
                questionLabel = R.string.round_tip_question,
                checked = roundTipUp,
                switchTestTag = roundTipSwitchTestTag,
                onCheckedChange = { roundTipUp = it }
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = R.string.tip_result_message, tipAmount),
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
            )
        }
    }
}

