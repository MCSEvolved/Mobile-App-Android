package josian.vanefferen.mcsynergy.view

import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import josian.vanefferen.mcsynergy.view.login.LoginScreen
import josian.vanefferen.mcsynergy.view.navbar.BottomNavigationBar
import josian.vanefferen.mcsynergy.view.navbar.NavBarItem
import josian.vanefferen.mcsynergy.view.navbar.Navigation

@Composable
fun MainView() {
    val navController = rememberNavController()
    var isLoggedIn by remember { mutableStateOf(false)}


    // Initialize Firebase Auth
    val firebaseAuth: FirebaseAuth = Firebase.auth
    firebaseAuth.addAuthStateListener {
        isLoggedIn = it.currentUser != null
    }
    isLoggedIn = firebaseAuth.currentUser != null


    if (isLoggedIn) {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        NavBarItem(
                            name = "Home",
                            route = "home",
                            icon = Icons.Filled.Home,
                        ),
                        NavBarItem(
                            name = "Notifications",
                            route = "notifications",
                            icon = Icons.Filled.Notifications
                        ),
                        NavBarItem(
                            name = "Settings",
                            route = "settings",
                            icon = Icons.Filled.Settings
                        ),
                    ),
                    navController = navController,
                    onItemclick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Navigation(navController = navController)
            }
        }
    } else {
        LoginScreen()
    }
}