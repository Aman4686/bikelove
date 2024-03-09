package com.example.bikelove.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainTheme(
    textSize: BikeLoveSize = BikeLoveSize.Medium,
    paddingSize: BikeLoveSize = BikeLoveSize.Medium,
    corners: BikeLoveCorners = BikeLoveCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        baseDarkPalette
    } else {
        baseLightPalette
    }

    val typography = BikeLoveTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 20.sp
                BikeLoveSize.Medium -> 22.sp
                BikeLoveSize.Big -> 24.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 14.sp
                BikeLoveSize.Medium -> 16.sp
                BikeLoveSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        bodyBold = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 14.sp
                BikeLoveSize.Medium -> 16.sp
                BikeLoveSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Bold
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 14.sp
                BikeLoveSize.Medium -> 16.sp
                BikeLoveSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 10.sp
                BikeLoveSize.Medium -> 12.sp
                BikeLoveSize.Big -> 14.sp
            }
        ),
        captionBold = TextStyle(
            fontSize = when (textSize) {
                BikeLoveSize.Small -> 10.sp
                BikeLoveSize.Medium -> 12.sp
                BikeLoveSize.Big -> 14.sp
            },
            fontWeight = FontWeight.Bold
        ),

        )

    val shapes = BikeLoveShape(
        padding = when (paddingSize) {
            BikeLoveSize.Small -> 12.dp
            BikeLoveSize.Medium -> 16.dp
            BikeLoveSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            BikeLoveCorners.Flat -> RoundedCornerShape(0.dp)
            BikeLoveCorners.Rounded -> RoundedCornerShape(16.dp)
        }
    )

    val LocalBikeLoveColors = staticCompositionLocalOf<BikeLoveColors>{
        colors
    }

    val LocalBikeLoveTypography = staticCompositionLocalOf<BikeLoveTypography> {
        typography
    }

    val LocalBikeLoveTestShape = staticCompositionLocalOf<BikeLoveShape> {
        shapes
    }

    CompositionLocalProvider(
        LocalBikeLoveColors provides colors,
        LocalBikeLoveTypography provides typography,
        LocalBikeLoveTestShape provides shapes,
        content = content
    )
}