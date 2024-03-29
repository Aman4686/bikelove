package com.example.bikelove.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bikelove.theme.BikeLoveTheme
import com.example.bikelove.theme.MainTheme

@Composable
fun FullScreenLoading() {
    Surface(color = BikeLoveTheme.colors.primaryBackground, modifier = Modifier
        .fillMaxSize()) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = BikeLoveTheme.colors.tintColor,
            )
        }
    }
}

@Preview
@Composable
fun FullScreenLoadingPreview() {
    MainTheme(darkTheme = false){
        FullScreenLoading()
    }
}