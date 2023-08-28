package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginCard(
    loginValue: String,
    onLoginValueChange: (String) -> Unit,
    loginErrorStatus: Boolean,
    passwordValue: String,
    onPasswordValueChange: (String) -> Unit,
    passwordErrorStatus: Boolean,
    onLoginButtonClicked: () -> Unit,
    rememberMeChecked: Boolean,
    rememberMeCheckedChange: () -> Unit
) {
    LoginCardAnimation {
        Card(
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(
                topStart = 36.dp,
                topEnd = 36.dp
            )
        ) {
            Column(
                Modifier
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoginText()

                Spacer(modifier = Modifier.height(10.dp))

                LoginTextField(
                    labelValue = "Username",
                    value = loginValue,
                    onValueChange = { onLoginValueChange(it) },
                    errorStatus = loginErrorStatus
                )

                Spacer(modifier = Modifier.height(10.dp))

                PasswordTextField(
                    labelValue = "Password",
                    value = passwordValue,
                    onValueChange = { onPasswordValueChange(it) },
                    errorStatus = passwordErrorStatus
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RememberMeButton(rememberMeChecked, rememberMeCheckedChange )
                    ForgetPasswordButton()
                }

                LoginButton(
                    label = "Login",
                    isLoginButtonEnabled = true,
                    onLoginButtonClicked = {
                        onLoginButtonClicked()
                        //navigateToMainScreen()
                    }
                )
            }
        }
    }
}
