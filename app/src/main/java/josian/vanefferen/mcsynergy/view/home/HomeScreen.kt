package josian.vanefferen.mcsynergy.view.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.topbar.LargeTopBar

@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeViewModel = hiltViewModel()
) {


    LargeTopBar(title = "Home", showBackButton = false, navController) {
        Button(onClick = { vm.logout() }) {
            Text(text = "Log-Out")
        }
    }

}