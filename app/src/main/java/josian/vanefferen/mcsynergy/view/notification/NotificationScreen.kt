package josian.vanefferen.mcsynergy.view.notification

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
fun NotificationScreen(navController: NavController) {
    LargeTopBar(title = "Notifications", showBackButton = false, navController) {

    }
}