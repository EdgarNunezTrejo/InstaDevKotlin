package com.eddev.instadev.view.core.navigation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstaButtonSecondary(
    modifier: Modifier,
    text: String = "",
    border: BorderStroke = BorderStroke(
        1.dp,
        MaterialTheme.colorScheme.primary
    ),
    onClick: () -> Unit
) {
    OutlinedButton(modifier = modifier, border = border, onClick = { onClick() }) {
        InstaText(text = text, color = MaterialTheme.colorScheme.primary)
    }
}