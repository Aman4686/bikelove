package com.example.bikelove.ui.authorization.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.theme.BikeLoveTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun AuthorizationViewDisplay(
    viewState: DisplayAuthorizationViewState,
    onLoginClicked: (phone: String, password: String) -> (Unit),
) {

    Surface(
        color = BikeLoveTheme.colors.primaryBackground
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            var phoneStateText by remember { mutableStateOf("") }
            var passwordStateText by remember { mutableStateOf("") }

            OutlinedTextField(
                value = phoneStateText,
                onValueChange = { phoneStateText = it },
                label = { Text("Phone") },
                modifier = Modifier.padding(bottom = 12.dp)
            )

            OutlinedTextField(
                value = passwordStateText,
                onValueChange = { passwordStateText = it },
                label = { Text("Password") }
            )

            Row(Modifier.padding(top = 12.dp)) {
                Button(onClick = {
                    onLoginClicked(phoneStateText, passwordStateText)
                }) {
                    Text(text = "Login")
                }
            }
        }
        showErrorMessage(viewState.authorizationErrorMessage)
    }
}

@Composable
fun showErrorMessage(errorMessage: String?) {

    val message = errorMessage ?: return
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = message,
            color = BikeLoveTheme.colors.errorColor
        )
    }
}

@Preview
@Composable
fun AuthorizationViewDisplayPreview() {
    AuthorizationViewDisplay(DisplayAuthorizationViewState("lol")) { phone, password ->

    }
}
