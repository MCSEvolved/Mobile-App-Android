package josian.vanefferen.mcsynergy.view.home.tracker.turtles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.home.tracker.turtles.cells.TurtleCell
import josian.vanefferen.mcsynergy.view.topbar.InlineTopBar

@Composable
fun TurtlesHomeScreen(
    navController: NavController
) {
    InlineTopBar(title = "Turtles", showBackButton = true, navController = navController) {
        Column(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
            .padding(it)
            .verticalScroll(rememberScrollState())
        )
        {
            Text(text = "CRASHED", fontSize = 12.sp, color = Color.Gray)
            TurtleCell()
            TurtleCell()
            TurtleCell()
            Spacer(Modifier.height(50.dp))
            Text(text = "SYSTEMS", fontSize = 12.sp, color = Color.Gray)
            SystemListItem(navController = navController, title = "No System", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Bee Farm", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Charcoal Farm", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Pumpkin Farm", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Froglight Farm", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Gold Farm", navDestination = "home/tracker/turtles/system")
            SystemListItem(navController = navController, title = "Wither Skeleton Farm", navDestination = "home/tracker/turtles/system")

        }
    }
}

@Composable
private fun SystemListItem(
    navController: NavController,
    title: String,
    navDestination: String
) {
    ListItem(
        headlineContent = {
            Column {
                Text(text = title)
            }

        },
        trailingContent = {
            Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = "Navigation Chevron",
            tint = Color.LightGray
        )
        },
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable { navController.navigate(navDestination) }
    )

    Divider()
}