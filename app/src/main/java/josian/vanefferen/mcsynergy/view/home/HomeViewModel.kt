package josian.vanefferen.mcsynergy.view.home

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import josian.vanefferen.mcsynergy.domain.auth.AuthService
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(authService: AuthService): ViewModel() {
    private val authService: AuthService

    init {
        this.authService = authService
    }
    fun logout() {
        Firebase.auth.signOut()
    }
}