package josian.vanefferen.mcsynergy.domain.auth

import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.qualifiers.ApplicationContext
import josian.vanefferen.mcsynergy.LoginActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthService @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val firebaseAuth: FirebaseAuth = Firebase.auth

    fun loginWithMicrosoft() {
        val intent = Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent)
    }

    fun loginAnonymously() {
        firebaseAuth.signInAnonymously()
            .addOnSuccessListener {result ->
                Log.w("AUTH", "Logged In as Guest")
            }
            .addOnFailureListener { result ->
                Log.w("AUTH", result)
            }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}