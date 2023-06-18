package josian.vanefferen.mcsynergy.view.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import josian.vanefferen.mcsynergy.domain.auth.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    authService: AuthService
): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    private val authService: AuthService
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    init {
        this.authService = authService
    }

    fun loginWithMicrosoft() {
        authService.loginWithMicrosoft()
    }

    fun loginAsGuest() {
        authService.loginAnonymously()
    }
}