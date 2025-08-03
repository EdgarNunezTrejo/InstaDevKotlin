//package com.eddev.instadev.view.auth.signup
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.AbsoluteAlignment
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.eddev.instadev.R
//import com.eddev.instadev.view.core.navigation.components.InstaButton
//import com.eddev.instadev.view.core.navigation.components.InstaButtonSecondary
//import com.eddev.instadev.view.core.navigation.components.InstaClickableText
//import com.eddev.instadev.view.core.navigation.components.InstaText
//import com.eddev.instadev.view.core.navigation.components.InstaTextField
//import com.eddev.instadev.view.core.navigation.components.InstaTopBar
//
//@Composable
//fun SignUpEmailScreen(signUpViewModel: SignUpViewModel = viewModel(), onPhoneSignUpClick: ()->Unit, onBackClick: ()->Unit) {
//    val uiState by signUpViewModel.uiSignUpState.collectAsStateWithLifecycle()
//    val annotatedText = buildAnnotatedString {
//        append("${stringResource(R.string.signup_screen_notification_disclaimer_email)} ")
//
//        pushStringAnnotation(tag = "MORE_INFO", annotation = "mas_info")
//        withStyle(
//            style = SpanStyle(
//                color = MaterialTheme.colorScheme.primary,
//            )
//        ) {
//            append(stringResource(R.string.signup_screen_notification_disclaimer_email_more_info))
//        }
//        pop()
//    }
//
//    Scaffold(topBar = {
//        InstaTopBar(onBackClick = {onBackClick()})
//    }) { padding ->
//        Column(
//            Modifier
//                .background(MaterialTheme.colorScheme.background)
//                .padding(padding)
//                .padding(horizontal = 24.dp)
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            InstaText(
//                modifier = Modifier
//                    .padding(top = 27.dp)
//                    .align(AbsoluteAlignment.Left),
//                text = stringResource(
//                    R.string.signup_screen_header_title,
//                    stringResource(R.string.signup_screen_method_email)
//                ),
//                style = MaterialTheme.typography.titleLarge
//            )
//            Spacer(Modifier.height(8.dp))
//            InstaText(
//                text = stringResource(
//                    R.string.signup_screen_header_disclaimer,
//                    stringResource(R.string.signup_screen_method_email)
//                ),
//            )
//            Spacer(Modifier.height(16.dp))
//            InstaTextField(
//                value = uiState.email,
//                onValueChange = { signUpViewModel.onEmailChange(it) },
//                label = stringResource(R.string.signup_screen_textbox_placeholder_email),
//                shape = MaterialTheme.shapes.medium
//            )
//            Spacer(Modifier.height(8.dp))
//            InstaClickableText(text = annotatedText, onMoreInfoClick = {}, style = MaterialTheme.typography.bodySmall)
//            Spacer(Modifier.height(16.dp))
//            InstaButton(
//                onClick = {}, text = stringResource(
//                    R.string.signup_screen_button_next
//                )
//            )
//            Spacer(Modifier.height(8.dp))
//            InstaButtonSecondary(
//                onClick = {onPhoneSignUpClick()}, text = stringResource(
//                    R.string.signup_screen_outlined_button_navigate_phone
//                )
//            )
//            Spacer(Modifier.weight(1f))
//            InstaText(
//                modifier = Modifier.clickable {  },
//                text = stringResource(
//                    R.string.signup_screen_text_find_my_account,
//                ),
//                color = MaterialTheme.colorScheme.primary
//            )
//            Spacer(Modifier.height(16.dp))
//        }
//    }
//}