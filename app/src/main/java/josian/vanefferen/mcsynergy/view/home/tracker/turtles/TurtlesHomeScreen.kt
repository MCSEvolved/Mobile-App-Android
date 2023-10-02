package josian.vanefferen.mcsynergy.view.home.tracker.turtles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import josian.vanefferen.mcsynergy.view.topbar.InlineTopBar

@Composable
fun TurtlesHomeScreen(
    navController: NavController
) {
    InlineTopBar(title = "Turtles", showBackButton = true, navController = navController) {
        Column(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .padding(it))
        {

        }
    }
}