package com.eddev.instadev.view.core.navigation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InstaButtonTertiary(modifier: Modifier = Modifier, text: String, onClick: ()->Unit) {
    TextButton (modifier = modifier, onClick = {onClick()}) {
        InstaText(
            text = text,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}