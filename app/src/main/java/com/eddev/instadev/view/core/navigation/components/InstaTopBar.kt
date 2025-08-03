package com.eddev.instadev.view.core.navigation.components

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.eddev.instadev.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstaTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "This is a back action",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        })
}