package josian.vanefferen.mcsynergy.view.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
fun SettingsScreen(
    navController: NavController,
    vm: SettingsViewModel = hiltViewModel()
) {
    val ui by vm.uiState.collectAsState()
    vm.loadUI()
    LargeTopBar("Settings", false, navController) {
        Column(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .padding(it)) {
            UserCard(ui, vm)
            Spacer(modifier = Modifier.height(30.dp))
            SettingsList(navController)


        }
    }
}

@Composable
private fun UserCard(ui: SettingsUiState, vm: SettingsViewModel) {

    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ),
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(start = 10.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .padding(10.dp),
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile Icon",
                    tint = Color.White
                )
                Column(modifier = Modifier.padding(top = 0.dp, bottom = 0.dp, start = 15.dp, end = 0.dp)) {
                    Text(text = ui.userName, fontSize = 30.sp)
                    Text(text = ui.role)
                }

            }
            Divider()
            TextButton(
                onClick = { vm.signOut() },
            ) {
                Text(text = "Sign Out", color = Color.Red, fontWeight = FontWeight.Light)
            }
        }

    }
}

@Composable
private fun SettingsList(navController: NavController) {
    ListItem(
        leadingContent = { Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notification Icon",
            tint = Color.White
        ) },
        headlineContent = { Text(text = "Notifications") },
//                modifier = Modifier
//                    .background(MaterialTheme.colors.surface)
        trailingContent = {Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = "Notification Icon",
            tint = Color.LightGray
        )},
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable { navController.navigate("settings/notifications") }
    )
    Divider()
}