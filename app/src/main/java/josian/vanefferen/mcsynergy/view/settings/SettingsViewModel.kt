package josian.vanefferen.mcsynergy.view.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import josian.vanefferen.mcsynergy.domain.auth.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val authService: AuthService
): ViewModel() {
    private val auth = Firebase.auth
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        loadUI()
    }

    fun loadUI() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        userName = if (currentUser.isAnonymous) "Guest User" else currentUser.displayName ?: "Guest User",
                        role = if (currentUser.isAnonymous) "Guest" else "Player"
                    )
                }
            }
        }
    }

    fun signOut() {
        authService.logout()
    }
}