package josian.vanefferen.mcsynergy.view.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.SettingsInputAntenna
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeViewModel = hiltViewModel()
) {

    LargeTopBar(title = "Home", showBackButton = false, navController) {
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .padding(it)) {
            ServiceCell(navController = navController,title = "Tracker", description = "Easy way to keep track of all your turtles and systems")


        }
    }
}

@Composable
private fun ServiceCell(
    navController: NavController,
    title: String,
    description: String
) {
    ListItem(
        leadingContent = { Icon(
            imageVector = Icons.Outlined.SettingsInputAntenna,
            contentDescription = "Icon",
            tint = Color.White
        ) },
        headlineContent = {
            Column {
                Text(text = title)
                Text(text = description, color = Color.Gray)
            }

        },
        trailingContent = {Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = "Notification Icon",
            tint = Color.LightGray
        )},
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable { navController.navigate("home/tracker") }
    )

    Divider()
}