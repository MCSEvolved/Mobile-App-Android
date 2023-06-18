package josian.vanefferen.mcsynergy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = LichtBlauw,
    secondary = HemelBlauw,
    tertiary = DonkerBlauw,
    background = BlauwZwart,
    surface = DonkerderBlauw,
    primaryContainer = DonkerderBlauw,
    onPrimaryContainer = Color.White,
    onPrimary = Color.White
)

//private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200,
//    background = Color.White,

    /* Other default colors to override

    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
//)

@Composable
fun MCSynergyAndroidTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}