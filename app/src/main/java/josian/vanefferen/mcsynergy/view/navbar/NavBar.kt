package josian.vanefferen.mcsynergy.view.navbar

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import josian.vanefferen.mcsynergy.view.home.HomeScreen
import josian.vanefferen.mcsynergy.view.notification.NotificationScreen
import josian.vanefferen.mcsynergy.view.settings.SettingsScreen
import josian.vanefferen.mcsynergy.view.settings.categories.notification.NotificationSettingsScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("notifications") {
            NotificationScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
        composable("settings/notifications") {
            NotificationSettingsScreen(navController)
        }



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<NavBarItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemclick: (NavBarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = Modifier
            .height(72.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            ),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,

        ) {
        items.forEach { item ->
            val selected = backStackEntry.value?.destination?.route?.startsWith(item.route) ?: false
            Log.d("ROUTE", "----------")
            Log.d("ROUTE", item.route)
            Log.d("ROUTE", backStackEntry.value?.destination?.route ?: "NO_ROUTE")
            Log.d("ROUTE", "----------")
            NavigationBarItem(
                selected = selected,
                onClick = { onItemclick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Gray,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                ),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Badge {
                                    Text(item.badgeCount.toString())
                                }
                            }) {
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }

//                        if(selected) {
//                            Text(
//                                text = item.name,
//                                textAlign = TextAlign.Center,
//                                fontSize = 10.sp
//                            )
//                        }
                    }
                }

            )
        }
    }

}