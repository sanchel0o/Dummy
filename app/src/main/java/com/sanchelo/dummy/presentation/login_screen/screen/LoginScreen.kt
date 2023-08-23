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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
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
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginCardAnimation
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginText
import com.sanchelo.dummy.presentation.login_screen.screen.components.LoginTextField
import com.sanchelo.dummy.presentation.login_screen.screen.components.PasswordTextField
import com.sanchelo.dummy.presentation.login_screen.screen.components.RememberMeButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(
    //navigateToMainScreen: () -> Unit
) {
    val viewModel: LoginScreenViewModel = hiltViewModel()

    val state by viewModel.loginScreenState.collectAsStateWithLifecycle()

    GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    DummyImage()
                }

                LoginCardAnimation {
                    Card(
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
                        shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
                    ) {
                        Column(
                            Modifier
                                .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LoginText()

                            Spacer(modifier = Modifier.height(10.dp))

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
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                RememberMeButton()
                                ForgetPasswordButton()
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth().navigationBarsPadding()
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
}


@Composable
fun LoginCard() {

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
