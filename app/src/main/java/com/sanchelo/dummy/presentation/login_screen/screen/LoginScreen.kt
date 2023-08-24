package com.sanchelo.dummy.presentation.login_screen.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sanchelo.dummy.presentation.login_screen.LoginScreenEvents
import com.sanchelo.dummy.presentation.login_screen.LoginScreenViewModel
import com.sanchelo.dummy.presentation.login_screen.screen.components.DummyImage
import com.sanchelo.dummy.presentation.login_screen.screen.components.GradientBackground
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginCard

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
            DummyImage(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )

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
