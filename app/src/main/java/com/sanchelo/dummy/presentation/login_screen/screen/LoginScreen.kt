package com.sanchelo.dummy.presentation.login_screen.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sanchelo.dummy.presentation.login_screen.LoginScreenViewModel
import com.sanchelo.dummy.presentation.login_screen.events.LoginScreenEvents
import com.sanchelo.dummy.presentation.login_screen.screen.components.DummyImage
import com.sanchelo.dummy.presentation.login_screen.screen.components.ForgetPasswordButton
import com.sanchelo.dummy.presentation.login_screen.screen.components.GradientBackground
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginButton
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginCard
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginCardAnimation
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginText
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginTextField
import com.sanchelo.dummy.presentation.login_screen.screen.components.PasswordTextField
import com.sanchelo.dummy.presentation.login_screen.screen.components.RememberMeButton

@Composable
fun LoginScreen(
    //navigateToMainScreen: () -> Unit
) {
    val viewModel: LoginScreenViewModel = hiltViewModel()

    val state by viewModel.loginScreenState.collectAsStateWithLifecycle()

    GradientBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .imePadding(),
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                DummyImage()
            }
            LoginCard(
                loginValue = state.login,
                onLoginValueChange = {
                    viewModel.onEvent(
                        LoginScreenEvents.OnLoginChanged(login = it)
                    )
                },
                loginErrorStatus = false,
                passwordValue = state.password,
                onPasswordValueChange = {
                    viewModel.onEvent(
                        LoginScreenEvents.OnPasswordChanged(password = it)
                    )
                },
                passwordErrorStatus = false,
                onLoginButtonClicked = { }
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
