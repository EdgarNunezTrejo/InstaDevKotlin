package com.eddev.instadev.view.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eddev.instadev.R
import com.eddev.instadev.view.core.navigation.components.InstaButton
import com.eddev.instadev.view.core.navigation.components.InstaButtonSecondary
import com.eddev.instadev.view.core.navigation.components.InstaClickableText
import com.eddev.instadev.view.core.navigation.components.InstaText
import com.eddev.instadev.view.core.navigation.components.InstaTextField
import com.eddev.instadev.view.core.navigation.components.InstaTopBar

@Composable
fun SignUpScreen(
    isPhoneMethod: Boolean = true,
    signUpViewModel: SignUpViewModel = viewModel(),
    onBackClick: () -> Unit,
) {

    val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
    val annotatedText = buildAnnotatedString {
        append("${stringResource(R.string.signup_screen_notification_disclaimer_email)} ")

        pushStringAnnotation(tag = "MORE_INFO", annotation = "mas_info")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
            )
        ) {
            append(stringResource(R.string.signup_screen_notification_disclaimer_email_more_info))
        }
        pop()
    }

    val title: String
    val screenMethodDisclaimer: String
    val placeholder: String
    val navigateButton: String

    when (uiState.isPhoneMode) {
        true -> {
            title = stringResource(R.string.signup_screen_method_phone)
            screenMethodDisclaimer = stringResource(R.string.signup_screen_method_phone)
            placeholder = stringResource(R.string.signup_screen_textbox_placeholder_phone)
            navigateButton = stringResource(R.string.signup_screen_outlined_button_navigate_email)
        }

        false -> {
            title = stringResource(R.string.signup_screen_method_email)
            screenMethodDisclaimer = stringResource(
                R.string.signup_screen_method_email
            )
            placeholder = stringResource(R.string.signup_screen_textbox_placeholder_email)
            navigateButton = stringResource(R.string.signup_screen_outlined_button_navigate_phone)
        }
    }

    Scaffold(topBar = {
        InstaTopBar(onBackClick = { onBackClick() })
    }) { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                modifier = Modifier
                    .padding(top = 27.dp)
                    .align(AbsoluteAlignment.Left),
                text = stringResource(
                    R.string.signup_screen_header_title,
                    title
                ),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            InstaText(
                text = stringResource(
                    R.string.signup_screen_header_disclaimer,
                    screenMethodDisclaimer
                ),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(16.dp))
            InstaTextField(
                value = uiState.value,
                onValueChange = { signUpViewModel.onValueChange(it) },
                label = placeholder,
                shape = MaterialTheme.shapes.medium
            )
            Spacer(Modifier.height(8.dp))
            if (isPhoneMethod) {
                InstaText(
                    text = stringResource(
                        R.string.signup_screen_notification_disclaimer_phone,
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            } else {
                InstaClickableText(
                    text = annotatedText,
                    onMoreInfoClick = {},
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(Modifier.height(16.dp))
            InstaButton(
                onClick = {}, text = stringResource(
                    R.string.signup_screen_button_next
                ),
                enabled = uiState.isSignUpEnabled
            )
            Spacer(Modifier.height(8.dp))
            InstaButtonSecondary(
                onClick = { signUpViewModel.onChangeMode() },
                text = navigateButton
            )
            Spacer(Modifier.weight(1f))
            InstaText(
                modifier = Modifier.clickable { },
                text = stringResource(
                    R.string.signup_screen_text_find_my_account,
                ),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}