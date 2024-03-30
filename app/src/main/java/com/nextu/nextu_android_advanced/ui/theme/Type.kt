package com.nextu.nextu_android_advanced.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.nextu.nextu_android_advanced.R

// Malheureusement Material 3 ne permet pas d'appliquer une font à toutes les typographies en 1 ligne
// Il convient donc de dupliquer tous les styles pour les mettre à jours avec notre font
private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = NextUFonts.TensorFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = NextUFonts.TensorFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = NextUFonts.TensorFontFamily),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = NextUFonts.TensorFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = NextUFonts.TensorFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = NextUFonts.TensorFontFamily),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = NextUFonts.TensorFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = NextUFonts.TensorFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = NextUFonts.TensorFontFamily),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = NextUFonts.TensorFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = NextUFonts.TensorFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = NextUFonts.TensorFontFamily),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = NextUFonts.TensorFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = NextUFonts.TensorFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = NextUFonts.TensorFontFamily)
)

object NextUFonts {
    val TensorFontFamily = FontFamily(
        Font(R.font.tenorsans_regular),
        Font(R.font.tenorsans_regular, FontWeight.Bold)
    )
}



