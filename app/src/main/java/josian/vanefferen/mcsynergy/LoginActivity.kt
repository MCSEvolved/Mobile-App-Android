package josian.vanefferen.mcsynergy

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import josian.vanefferen.mcsynergy.ui.theme.MCSynergyAndroidTheme
import josian.vanefferen.mcsynergy.view.MainView

@AndroidEntryPoint
class LoginActivity: ComponentActivity() {
    private lateinit var provider: OAuthProvider.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        loginWithMicrosoft()

        setContent {
            MCSynergyAndroidTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Signing in, please wait...", color = Color.White)
                }
            }
        }
    }



    private fun loginWithMicrosoft() {
        provider = OAuthProvider.newBuilder("microsoft.com")
        val firebaseAuth = Firebase.auth
        val pendingResultTask = firebaseAuth.pendingAuthResult
        if (pendingResultTask != null) {
            pendingResultTask
                .addOnSuccessListener {
                    // User is signed in.
                    // IdP data available in
                    // authResult.getAdditionalUserInfo().getProfile().
                    // The OAuth access token can also be retrieved:
                    // ((OAuthCredential)authResult.getCredential()).getAccessToken().
                    // The OAuth secret can be retrieved by calling:
                    // ((OAuthCredential)authResult.getCredential()).getSecret().
                    Log.w("AUTH", "Logged In")
                    finish()
                }
                .addOnFailureListener {
                    // Handle failure.
                    Log.w("AUTH", it)
                    finish()
                }
        } else {
            firebaseAuth
                .startActivityForSignInWithProvider( this, provider.build())
                .addOnSuccessListener {
                    // User is signed in.
                    // IdP data available in
                    // authResult.getAdditionalUserInfo().getProfile().
                    // The OAuth access token can also be retrieved:
                    // ((OAuthCredential)authResult.getCredential()).getAccessToken().
                    // The OAuth secret can be retrieved by calling:
                    // ((OAuthCredential)authResult.getCredential()).getSecret().
                    Log.w("AUTH", "Logged In")
                    finish()
                }
                .addOnFailureListener {
                    // Handle failure.
                    Log.w("AUTH", it)
                    finish()
                }
        }
    }

}