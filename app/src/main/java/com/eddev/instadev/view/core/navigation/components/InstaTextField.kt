package com.eddev.instadev.view.core.navigation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.eddev.instadev.R

@Composable
fun InstaTextField(modifier: Modifier = Modifier, value: String, shape: Shape = MaterialTheme.shapes.large, onValueChange: (String)->Unit, label: String) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        value = value,
        onValueChange = onValueChange,
        label = {
            InstaText(
                text = label,
            )
        },
        colors = OutlinedTextFieldDefaults.colors()
    )
}