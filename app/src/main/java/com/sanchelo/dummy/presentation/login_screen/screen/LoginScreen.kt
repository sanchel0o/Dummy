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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginScreenAnimation
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
                .fillMaxWidth()
                .systemBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f)) {
                DummyImage()
            }
            Box(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.height(20.dp))
                LoginScreenAnimation {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding(),
                        shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LoginText()
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        Column(
                            modifier = Modifier.padding(start = 12.dp, end = 12.dp)
                        ) {
                            LoginTextField(
                                labelValue = "Username",
                                value = state.login,
                                onValueChange = {
                                    viewModel.onEvent(
                                        LoginScreenEvents.OnLoginChanged(login = it)
                                    )
                                },
                                errorStatus = false
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            PasswordTextField(
                                labelValue = "Password",
                                value = state.password,
                                onValueChange = {
                                    viewModel.onEvent(
                                        LoginScreenEvents.OnPasswordChanged(password = it)
                                    )
                                },
                                errorStatus = false
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 12.dp, end = 12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                RememberMeButton()
                                ForgetPasswordButton()
                            }
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
                                .systemBarsPadding()
                        ) {
                            LoginButton(
                                label = "Login",
                                isLoginButtonEnabled = true,
                                onLoginButtonClicked = {
                                    //navigateToMainScreen()
                                }
                            )
                        }
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
