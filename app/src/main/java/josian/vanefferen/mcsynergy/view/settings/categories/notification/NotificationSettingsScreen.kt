package josian.vanefferen.mcsynergy.view.settings.categories.notification

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
private fun NotificationToggle(title: String, topic: String) {
    val vm: NotificationSettingsViewModel = hiltViewModel()
    var enabled: Boolean by remember { mutableStateOf(false)}
    vm.getStateofTopic(topic) {
        enabled = it
    }
    ListItem(
        leadingContent = { Text(text = title, color = Color.White)},
        trailingContent = { Switch(
            checked = enabled,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Gray,
                uncheckedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedBorderColor = MaterialTheme.colorScheme.primaryContainer
            ),
            onCheckedChange = {
                enabled = it
                vm.changeStateOfTopic(topic, it)
                              },
            enabled = true
        ) },
        headlineContent = {},
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        )
    )
    Divider()
}

@Composable
private fun Section(title: String, toggles: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(bottom = 50.dp)) {
        Text(text = title, color = MaterialTheme.colorScheme.primary, fontSize = 12.sp, fontWeight = FontWeight.Light, modifier = Modifier.padding(top = 10.dp))
        toggles()
    }
    
    
}



@Composable
fun NotificationSettingsScreen(navController: NavController) {
    LargeTopBar(title = "Notifications", showBackButton = true, navController = navController) {
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .padding(it)
            .verticalScroll(rememberScrollState())
        ) {
            Section(title = "Minecraft Server Status") {
                NotificationToggle(title = "Shut on/off", topic = "mc-server")
            }

            Section(title = "Service Status") {
                NotificationToggle(title = "Tracker", topic = "service-status_tracker")
                NotificationToggle(title = "Storage", topic = "service-status_storage")
                NotificationToggle(title = "EmeraldExchange", topic = "service-status_emerald-exchange")
                NotificationToggle(title = "ReactorManager", topic = "service-status_reactor-manager")
            }

            Section(title = "Power Management") {
                NotificationToggle(title = "Power Shortage", topic = "power-management_shortage")
                NotificationToggle(title = "Reactor Shut off", topic = "power-management_reactor-shut-off")
            }

            Section(title = "Tracker") {
                NotificationToggle(title = "Error Messages", topic = "tracker_error")
                NotificationToggle(title = "Warning Messages", topic = "tracker_warning")
                NotificationToggle(title = "Out of Fuel", topic = "tracker_out-of-fuel")
            }

            Section(title = "Personal") {
                NotificationToggle(title = "Weekly Reports", topic = "user_weekly-report")
            }

        }
    }
}