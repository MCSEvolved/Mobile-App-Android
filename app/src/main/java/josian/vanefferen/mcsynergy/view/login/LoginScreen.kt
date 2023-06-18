package josian.vanefferen.mcsynergy.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import josian.vanefferen.mcsynergy.R
import josian.vanefferen.mcsynergy.domain.auth.AuthService
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun LoginScreen(
    vm: LoginViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.logowide),
            contentDescription = "",
            modifier = Modifier.padding(top = 230.dp, start = 40.dp, end = 40.dp)
        )
        Column(modifier = Modifier
            .padding(bottom = 40.dp)
            .width(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { vm.loginWithMicrosoft() }, modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.logo_icon),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 0.dp, end = 7.dp)
                    )
                    Text(text = "Sign in as MCS Player")
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { vm.loginAsGuest() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(text = "Continue as Guest", color = MaterialTheme.colorScheme.primary)
            }
        }

    }

}