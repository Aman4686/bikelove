package com.example.bikelove.ui.registration.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.theme.BikeLoveTheme

@Composable
fun RegistrationViewDisplay(
    viewState: DisplayAuthorizationViewState,
) {
    Surface(
        color = BikeLoveTheme.colors.primaryBackground
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

        }
    }
}
