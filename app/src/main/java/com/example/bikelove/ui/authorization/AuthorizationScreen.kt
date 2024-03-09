package com.example.bikelove.ui.authorization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.example.bikelove.navigation.NavRoutes
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.ui.authorization.state.ErrorAuthorizationViewState
import com.example.bikelove.ui.authorization.state.AuthorizationViewEvent
import com.example.bikelove.ui.authorization.state.LoadingAuthorizationViewState
import com.example.bikelove.ui.authorization.state.SuccessAuthorizationViewState
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
            AuthorizationViewDisplay(
                viewState = state,
                onLoginClicked = { phone, password ->
                    viewModel.obtainEvent(
                        AuthorizationViewEvent.Login(
                            phone = phone,
                            password = password
                        )
                    )
                }
            )
        }
        is SuccessAuthorizationViewState -> {
            navController.navigate(NavRoutes.ItemList.route)
        }
        is LoadingAuthorizationViewState -> {
            FullScreenLoading()
        }

        is ErrorAuthorizationViewState -> {
            //TODO Show error screen
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = AuthorizationViewEvent.Initial)
    })
}