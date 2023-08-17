package com.rafaeltmbr.tipcalculator.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@ExperimentalMaterial3Api
@Composable
fun NumericField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Default,
) {
    TextField(
        label = { Text(text = stringResource(id = label)) },
        value = value,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction,
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
    )
}