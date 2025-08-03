package com.eddev.instadev.view.core.navigation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle

@Composable
fun InstaClickableText(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    text: AnnotatedString,
    onMoreInfoClick: () -> Unit,
) {
    Text(
        text = text,
        modifier = modifier.clickable {
            onMoreInfoClick()
        },
        color = color,
        style = style,
    )
}