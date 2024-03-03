package com.example.bikelove.ui.authorization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.ui.authorization.state.ErrorAuthorizationViewState
import com.example.bikelove.ui.authorization.state.InitialAuthorizationViewState
import com.example.bikelove.ui.authorization.state.LoadingAuthorizationViewState
import com.example.bikelove.ui.authorization.view.AuthorizationViewDisplay
import com.example.bikelove.ui.component.FullScreenLoading

@Composable
fun AuthorizationScreen(
    navController: NavController,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val viewState by viewModel.authorizationViewStateFlow.collectAsState()

    when (val state = viewState) {
        is DisplayAuthorizationViewState -> {
            AuthorizationViewDisplay(state)
        }
        is LoadingAuthorizationViewState -> {
            FullScreenLoading()
        }
        is ErrorAuthorizationViewState -> {
            //TODO Show error screen
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = InitialAuthorizationViewState)
    })
}