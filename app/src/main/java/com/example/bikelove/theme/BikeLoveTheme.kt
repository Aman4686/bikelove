package com.example.bikelove.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class BikeLoveColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class BikeLoveTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val bodyBold: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle,
    val captionBold: TextStyle
)

data class BikeLoveShape(
    val padding: Dp,
    val cornersStyle: Shape
)

object BikeLoveTheme {
    val colors: BikeLoveColors
        @Composable
        get() = LocalBikeLoveColors.current

    val typography: BikeLoveTypography
        @Composable
        get() = LocalBikeLoveTypography.current

    val shapes: BikeLoveShape
        @Composable
        get() = LocalBikeLoveTestShape.current
}

val LocalBikeLoveColors = staticCompositionLocalOf<BikeLoveColors>{
    baseLightPalette
}

val LocalBikeLoveTypography = staticCompositionLocalOf<BikeLoveTypography> {
    error("No font provided")
}

val LocalBikeLoveTestShape = staticCompositionLocalOf<BikeLoveShape> {
    error("No shapes provided")
}

enum class BikeLoveSize {
    Small, Medium, Big
}

enum class BikeLoveCorners {
    Flat, Rounded
}
