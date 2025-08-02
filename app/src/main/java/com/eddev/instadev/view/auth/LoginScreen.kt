package com.eddev.instadev.view.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eddev.instadev.R
import com.eddev.instadev.view.core.navigation.components.InstaButton
import com.eddev.instadev.view.core.navigation.components.InstaButtonSecondary
import com.eddev.instadev.view.core.navigation.components.InstaButtonTertiary
import com.eddev.instadev.view.core.navigation.components.InstaText

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()


    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (España)",
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "Instadev logo"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge,
                value = uiState.email,
                onValueChange = { loginViewModel.onEmailChange(it) },
                label = {
                    InstaText(
                        text = "Usuario, correo electrónico o móvil",
                    )
                }
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge,
                value = uiState.password, onValueChange = { loginViewModel.onPasswordChange(it) },
                label = {
                    InstaText(
                        text = "Contraseña",
                    )
                }

            )
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Iniciar sesión",
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {},
                shape = MaterialTheme.shapes.extraLarge,
                enabled = uiState.isLoginEnabled,
            )
            InstaButtonTertiary( text = "", onClick = {})
            Spacer(Modifier.weight(1.3f))
            InstaButtonSecondary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                onClick = {},
            )
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = "Meta logo",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}