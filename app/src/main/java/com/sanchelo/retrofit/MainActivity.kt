package com.sanchelo.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanchelo.retrofit.remote.MainAPI
import com.sanchelo.retrofit.ui.theme.RetrofitTheme
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://dummyjson.com/").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mainAPI = retrofit.create(MainAPI::class.java)

        setContent {
            RetrofitTheme {

            }
        }
    }
}


@Composable
//@Preview(showBackground = true)
fun Login() {
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.fillMaxSize()
            .navigationBarsPadding(),
        contentAlignment = BottomCenter,

        ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.Bottom
            ),
            horizontalAlignment = CenterHorizontally
        ) {
            TextInput(InputType.Name,
                keyboardActions = KeyboardActions(onNext = {
                passwordFocusRequester.requestFocus()
            }))
            TextInput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)
            Button(
                modifier = Modifier,
                onClick = { /*TODO*/ }
            )
            {
                Text(text = "Sign Up")
            }

            Divider(
                color = Color.White.copy(0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Don't have an account?", color = Color.Gray)
                TextButton(onClick = { /*TODO*/ }) {
                    Text("SIGN UP")
                }
            }

        }
    }
}

sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Name : InputType(
        label = "Username",
        icon = Icons.Default.Person,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions
) {
    var value by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = value,
        modifier = Modifier.focusRequester(focusRequester ?: FocusRequester()),
        onValueChange = { value = it },
        leadingIcon = { Icon(imageVector = inputType.icon, null) },
        label = { Text(text = inputType.label) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation

    )
}

//@Composable
//@Preview
//fun Toolbar() {
//    Row(
//        modifier = Modifier
//            .height(44.dp)
//            .fillMaxWidth(fraction = 1f)
//            .background(color = MaterialTheme.colorScheme.background)
//    ) {
//
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@Preview
//fun ShowUserData() {
//    var email by rememberSaveable { mutableStateOf("") }
//    var password by rememberSaveable { mutableStateOf("") }
//
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Center
//    ) {
//
//        Column(
//            modifier = Modifier,
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = CenterHorizontally
//
//            ) {
//
//            Text(
//                text = "Hello",
//                color = Color.LightGray,
//                fontSize = 30.sp
//
//            )
//            Text(
//                text = "There",
//                color = Color.LightGray,
//                fontSize = 18.sp
//            )
//
//            OutlinedTextField(
//                modifier = Modifier
//                    .align(CenterHorizontally)
//                    .padding(top = 20.dp),
//
//                value = email,
//                onValueChange = { textFieldState = it },
//                singleLine = true,
//                label = { Text("Login or e-mail") }
//            )
//            OutlinedTextField(
//                modifier = Modifier
//                    .align(CenterHorizontally),
//                value = password,
//                onValueChange = { textFieldState = it },
//                singleLine = true,
//                label = { Text("Password") }
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//            Button(
//                modifier = Modifier
//                    .align(CenterHorizontally),
//                onClick = {}
//            ) {
//                Text(text = "Show")
//            }
//        }
//    }
//
//}
