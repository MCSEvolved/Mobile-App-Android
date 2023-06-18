package josian.vanefferen.mcsynergy.domain.notification


import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
class NotificationService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "notificationSettings")
    }


    suspend fun getStateOfTopic(topic: String): Boolean {
        val topicKey = booleanPreferencesKey(topic)
        val topicFlow: Flow<Boolean> = context.dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[topicKey] ?: false
            }
        return topicFlow.first()
    }

    suspend fun changeStateOfTopic(topic: String, state: Boolean) {
        val topicKey = booleanPreferencesKey(topic)
        context.dataStore.edit { settings ->
            settings[topicKey] = state
        }

        if (state) {
            Firebase.messaging.subscribeToTopic(topic)
        } else {
            Firebase.messaging.unsubscribeFromTopic(topic)
        }


    }


}