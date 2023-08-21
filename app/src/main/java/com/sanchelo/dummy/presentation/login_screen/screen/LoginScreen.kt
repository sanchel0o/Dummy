package com.sanchelo.dummy.presentation.login_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.sanchelo.dummy.presentation.login_screen.screen.components.GradientBackground
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginButton
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginTextField
import com.sanchelo.dummy.presentation.login_screen.screen.components.PasswordTextField

@Composable
fun LoginScreen(
    //navigateToMainScreen: () -> Unit
) {
    val viewModel: LoginScreenViewModel = hiltViewModel()

    val state by viewModel.loginScreenState.collectAsStateWithLifecycle()

    GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 24.dp, start = 12.dp, end = 12.dp, bottom = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DummyImage()

                    Spacer(modifier = Modifier.height(10.dp))

                    LoginTextField(
                        labelValue = "Login",
                        value = state.login,
                        onValueChange = { viewModel.onEvent(LoginScreenEvents.OnLoginChanged(login = it)) },
                        errorStatus = false
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    PasswordTextField(
                        labelValue = "Password",
                        value = state.password,
                        onValueChange = { viewModel.onEvent(LoginScreenEvents.OnPasswordChanged(password = it)) },
                        errorStatus = false
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LoginButton(
                        label = "Login",
                        isLoginButtonEnabled = true,
                        onLoginButtonClicked = {

                            //navigateToMainScreen()
                        }
                    )

                    TextButton(
                        onClick = {}
                    ) {
                        Text(text = "Forget password?")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
