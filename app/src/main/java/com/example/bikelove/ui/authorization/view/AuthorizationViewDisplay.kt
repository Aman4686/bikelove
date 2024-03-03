package com.example.bikelove.ui.authorization.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.luxsofttest.ui.theme.BikeLoveTheme

@Composable
fun AuthorizationViewDisplay(
    viewState: DisplayAuthorizationViewState,
) {
    Surface(
        color = BikeLoveTheme.colors.primaryBackground
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Lol")
        }
    }
}
