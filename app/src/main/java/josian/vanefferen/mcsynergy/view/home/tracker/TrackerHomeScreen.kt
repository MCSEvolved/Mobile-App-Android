package josian.vanefferen.mcsynergy.view.home.tracker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.SettingsInputAntenna
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
fun TrackerHomeScreen(
    navController: NavController
) {
    LargeTopBar(title = "Tracker", showBackButton = true, navController = navController) {
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .padding(it)) {
            TrackerCategoryCell(
                navController = navController,
                title = "Turtles",
                icon = Icons.Outlined.SmartToy,
                navDestination = "home/tracker/turtles"
            )
        }
    }
}

@Composable
private fun TrackerCategoryCell(
    navController: NavController,
    title: String,
    icon: ImageVector,
    navDestination: String
) {
    ListItem(
        leadingContent = { Icon(
            imageVector = icon,
            contentDescription = "Icon",
            tint = Color.White
        ) },
        headlineContent = {
            Column {
                Text(text = title)
            }

        },
        trailingContent = {Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = "Navigation Chevron",
            tint = Color.LightGray
        )},
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable { navController.navigate(navDestination) }
    )

    Divider()
}