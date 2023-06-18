package josian.vanefferen.mcsynergy.view.settings.categories.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import josian.vanefferen.mcsynergy.domain.notification.NotificationService
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationSettingsViewModel @Inject constructor(
    private val notificationService: NotificationService
): ViewModel() {
    fun getStateofTopic(topic: String, onSucces: (Boolean) -> Unit) {
        viewModelScope.launch {
            onSucces(notificationService.getStateOfTopic(topic))
        }
    }

    fun changeStateOfTopic(topic: String, state: Boolean) {
        viewModelScope.launch {
            notificationService.changeStateOfTopic(topic, state)
        }
    }
}